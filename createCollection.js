//using MongoDB module
var MongoClient = require('mongodb').MongoClient;

// loading MongoDB url
var url = "mongodb://localhost:27017/";

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