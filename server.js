let express = require('express'),
    app = express(),
    bodyParser = require('body-parser'),
    multer = require('multer');
    xlsxtojson = require('xlsx-to-json'),
    xlstojson = require("xls-to-json");
 
let fileExtension = require('file-extension');
 
    app.use(bodyParser.json());  
 
    let storage = multer.diskStorage({ //multers disk storage settings
        destination: function (req, file, cb) {
            cb(null, './input/')
        },
        filename: function (req, file, cb) {
            cb(16, function (err, raw) {
                cb(null, raw.toString('hex') + Date.now() + '.' + fileExtension(file.mimetype));
                });
        }
    });
 
    let upload = multer({storage: storage}).single('file');
 
    //  Method to handle the form submit 
    app.post('/sendFile', function(req, res) {
        upload(req,res,function(err){
            if(err){
                 res.json({error_code:401,err_desc:err});
                 return;
            }
            if(!req.file){
                res.json({error_code:404,err_desc:"File not found!"});
                return;
            }
 
            if(req.file.originalname.split('.')[req.file.originalname.split('.').length-1] === 'csv'){
                let fileOutputName = 'output.json';
                csvToJson.generateJsonFileFromCsv(fie.originalname,fileOutputName);
                var url = "mongodb://localhost:27017/studentDB";
            MongoClient.connect(url, function(err, db) {
	if (err) throw err;
	console.log("Database created!");
	db.close();
});
MongoClient.connect(url, function(err, db) {
	if (err) throw err;
	// specifying the DB name
	var dbo = db.db("studentDB");
	// creating collection
	dbo.createCollection("StudentRecord", function(err, res) {
		if (err) throw err;
		console.log("Collection created!");
		db.close();
	});
}); 
MongoClient.connect(url, function(err, db) {
    if (err) throw err;
    // specifying the DB name
    var dbo = db.db("studentDB");
    // reading the JSON file
    var myobj = require("./output.json")
  
    // inserting the JSON file into 'StudentRecord' collection in 'studentDB' database
    dbo.collection("StudentRecord").insertMany(myobj, function(err, res) {
      if (err) throw err;
      console.log("Number of documents inserted: " + res.insertedCount);
      db.close();
    });
  });
} 
else if(req.file.originalname.split('.')[req.file.originalname.split('.').length-1] === 'xlsx'){
    xlsxj({
        input: file.originalname, 
        output: "output.json"
      }, function(err, result) {
        if(err) {
          console.error(err);
        }else {
          console.log(result);
        }
      });
    var url = "mongodb://localhost:27017/studentDB";
            MongoClient.connect(url, function(err, db) {
	if (err) throw err;
	console.log("Database created!");
	db.close();
});
MongoClient.connect(url, function(err, db) {
	if (err) throw err;
	// specifying the DB name
	var dbo = db.db("studentDB");
	// creating collection
	dbo.createCollection("StudentRecord", function(err, res) {
		if (err) throw err;
		console.log("Collection created!");
		db.close();
	});
}); 
MongoClient.connect(url, function(err, db) {
    if (err) throw err;
    // specifying the DB name
    var dbo = db.db("studentDB");
    // reading the JSON file
    var myobj = require("./output.json")
  
    // inserting the JSON file into 'StudentRecord' collection in 'studentDB' database
    dbo.collection("StudentRecord").insertMany(myobj, function(err, res) {
      if (err) throw err;
      console.log("Number of documents inserted: " + res.insertedCount);
      db.close();
    });
  });           
    
            }

        else{
            req.send('could not convert')
        }
 
           //  code to convert excel data to json  format
            
        })
       
    });
    // load index file to upload file on http://localhost:3000/
    app.get('/',function(req,res){
        res.sendFile(__dirname + "/index.html");
    });
 
    app.listen('3000', function(){
        console.log('Server running on port 3000');
    });