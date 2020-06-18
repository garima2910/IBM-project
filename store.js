//using MongoDB module
var MongoClient = require('mongodb').MongoClient;

// loading MongoDB url
var url = "mongodb://localhost:27017/";

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