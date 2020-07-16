const fs = require('fs');
const multer = require('multer');
const express = require('express');
const excelToJson = require('convert-excel-to-json');
let MongoClient = require('mongodb').MongoClient;
let url = "mongodb://localhost:27017/";
const csv=require('csvtojson')




const app = express();
 
global.__basedir = __dirname;
 
// -> Multer Upload Storage
const storage = multer.diskStorage({
 destination: (req, file, cb) => {
    cb(null, __basedir + '/uploads/')
 },
 filename: (req, file, cb) => {
    cb(null, file.fieldname + "-" + Date.now() + "-" + file.originalname)
 }
});
 
const upload = multer({storage: storage});
 
// -> Express Upload RestAPIs
app.post('/api/uploadfile', upload.single("uploadfile"), (req, res) =>{
    if(req.file.mimetype=="text/csv"){
    importCsvData2MongoDB(__basedir + '/uploads/' + req.file.filename);
    res.json({
        'msg': 'File uploaded/import successfully!', 'file': req.file
    });
}else if(req.file.mimetype=="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"){
    importExcelData2MongoDB(__basedir + '/uploads/' + req.file.filename);
    res.json({
        'msg': 'File uploaded/import successfully!', 'file': req.file
    });
}else{
    res.json('connot convert this type');
}
});
function importExcelData2MongoDB(filePath){
    // -> Read Excel File to Json Data
    const excelData = excelToJson({
        sourceFile: filePath,
        sheets:[{
            // Excel Sheet Name
            name: 'student',
 
            // Header Row -> be skipped and will not be present at our result object.
            header:{
               rows: 1
            },
			
            // Mapping columns to keys
            columnToKey: {
                A: 'BRANCH',
                B: 'SAP ID',
                C: 'ROLL NO',
                D: 'BATCH',
                E: 'NAME',
                F: 'CGPA'
            }
        }]
    });
 
    // -> Log Excel Data to Console
    console.log(excelData);
    var myJSON = JSON.stringify(excelData);

    // Insert Json-Object to MongoDB
    MongoClient.connect(url, { useNewUrlParser: true }, (err, db) => {
        if (err) throw err;
        let dbo = db.db("StudentDatabase");
        dbo.collection("students").insertMany(excelData.student, (err, res) => {
            if (err) throw err;
            console.log("Number of documents inserted: " + res.insertedCount);
            /**
                Number of documents inserted: 5
            */
            db.close();
        });
    });
			
    fs.unlinkSync(filePath);
}

 
// -> Import CSV File to MongoDB database
function importCsvData2MongoDB(filePath){
    csv()
        .fromFile(filePath)
        .then((jsonObj)=>{
            console.log(jsonObj);
            var myJSON= JSON.stringify(jsonObj);

            

            // Insert Json-Object to MongoDB
            MongoClient.connect(url, { useNewUrlParser: true }, (err, db) => {
                if (err) throw err;
                let dbo = db.db("StudentDatabase");
                dbo.collection("students").insertMany(jsonObj, (err, res) => {
                   if (err) throw err;
                   console.log("Number of documents inserted: " + res.insertedCount);
                   /**
                       Number of documents inserted: 5
                   */
                   db.close();
                });
            });
			
            fs.unlinkSync(filePath);
        })
    
}
 
// Create a Server
let server = app.listen(4000, function () {
 
  let host = server.address().address;
  let port = server.address().port;
 
  console.log("App listening at http://%s:%s", host, port);
})