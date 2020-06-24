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




