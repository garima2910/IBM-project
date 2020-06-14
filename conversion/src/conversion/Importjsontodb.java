package conversion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Importjsontodb {
	 public static void importJsonIntoCollection(String dbName,String collname) throws org.json.simple.parser.ParseException{
		   MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		   DB db = mongoClient.getDB(dbName);
		   DBCollection coll = db.getCollection(collname);
		   JSONParser parser = new JSONParser();
		   try{
			  Object obj = parser.parse(new FileReader("output.json"));
			  JSONArray jsonarray = (JSONArray)obj;

			     for (int i=0; i<jsonarray.size(); i++) {
	                     Object o = com.mongodb.util.JSON.parse(jsonarray.get(i).toString());
			     DBObject doc = (DBObject) o;
			     coll.insert(doc);
			     }
			     
		        }catch (FileNotFoundException e){
			 		e.printStackTrace();
			} catch (IOException e) {
			 		e.printStackTrace();
			}
			     
	 }

}
