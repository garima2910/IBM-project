//using MongoDB module
var MongoClient = require('mongodb').MongoClient;

//creating database 'studentDB' (if already not created)
var url = "mongodb://localhost:27017/studentDB";
MongoClient.connect(url, function(err, db) {
	if (err) throw err;
	console.log("Database created!");
	db.close();
});