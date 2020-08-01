package com.javainuse.main;

import java.io.IOException;

import org.drools.compiler.compiler.DroolsParserException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.JSONValue;

public class Validation {
	public static void main(String[] args) throws Exception {

		File file_ = 
		new File("C:\\Users\\Garima\\Documents\\GitHub\\IBM-project\\drools-hello-world\\file.json"); 
		Scanner sc = new Scanner(file_); 
		String[] data=sc.nextLine().split("{");

	public boolean validateJSONdata(String[] data  )throws DroolsParserException, IOException {
		
		Object object = JSONValue.parse(data);
		
		JSONObject jsonObject1 = (JSONObject) object;
		JSONArray fields= (JSONArray) jsonObject1.get(data);
		
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
