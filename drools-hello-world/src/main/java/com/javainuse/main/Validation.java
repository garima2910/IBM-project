package com.javainuse.main;

//Java program to read JSON from a file 

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import com.javainuse.main.DroolsStudent.*;

import org.drools.compiler.compiler.DroolsParserException;
import java.io.IOException;

public class Validation {
	/*public static void main(String[] args) throws Exception {

		String data = "{"
						+ "\"StudentRecord\": ["
						+ "{"
						+ "\"Branch\": \"BAO\"," + "\"Roll No\": \"R103217016\","
						+ "\"Sapid\": 500063399," + "\"Batch\": 1,"
						+ "\"Name\": \"Anchit\"," + "\"Cgpa\": 8.87"
						+ "}," 
						+ "{" 
						+ "\"Branch\": \"BAO\"," + "\"Roll No\": \"R103217018\","
						+ "\"Sapid\": 500061988," + "\"Batch\": 1,"
						+ "\"Name\": \"Anmol\"," + "\"Cgpa\": 7.05"
						+ "}"
						+ "]"
					+ "}";
		Validation ob = new Validation();
		ob.validateJSONdata(data);
	}*/

	public boolean validateJSONdata(String data)throws DroolsParserException, IOException {
		
		Object object = JSONValue.parse(data);
		
		JSONObject jsonObject1 = (JSONObject) object;
		JSONArray fields= (JSONArray) jsonObject1.get("StudentRecord");
		
		boolean f = true;
		
		for (Object field: fields) {
		JSONObject jsonObject = (JSONObject) field;

		        //Reading the String
				String branch = (String) jsonObject.get("Branch");
				String rollno = (String) jsonObject.get("Roll No");
				Object sap =  jsonObject.get("Sapid");
				long sapid = Long.parseLong(String.valueOf(sap));
				Object b =  jsonObject.get("Batch");
				int batch = Integer.parseInt(String.valueOf(b));
				String name = (String) jsonObject.get("Name");
		        Object c = jsonObject.get("Cgpa");
		        float cgpa = Float.parseFloat(String.valueOf(c));
		         
		        DroolsStudent droolsTest = new DroolsStudent();
				f = droolsTest.executeDrools(branch, rollno, sapid, batch, name, cgpa);
				
				if(f == false) {
					return f;
				}
		}
		
		return f;
	}
}
