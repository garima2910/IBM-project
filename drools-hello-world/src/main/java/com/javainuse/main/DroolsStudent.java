package com.javainuse.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;

import com.javainuse.model.Student;

public class DroolsStudent {

	/*public static void main(String[] args) throws DroolsParserException, IOException {
		DroolsStudent droolsTest = new DroolsStudent();
		boolean f = droolsTest.executeDrools("BAO", "R103217016", 500063397, 1, "Anchit", 8.87f);
		System.out.println(f);
	}*/

	public boolean executeDrools(String branch, String rollno, long sapid, 
			int batch, String name, float cgpa) throws DroolsParserException, IOException {

		PackageBuilder packageBuilder = new PackageBuilder();

		String ruleFile = "/com/rule/Rules_stu.drl";
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);

		Reader reader = new InputStreamReader(resourceAsStream);
		packageBuilder.addPackageFromDrl(reader);
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		WorkingMemory workingMemory = ruleBase.newStatefulSession();

		Student s1 = new Student();
		s1.setBranch(branch);
		s1.setRollNo(rollno);
		s1.setSapId(sapid);
		s1.setBatch(batch);
		s1.setName(name);
		s1.setCgpa(cgpa);
		
		workingMemory.insert(s1);
		workingMemory.fireAllRules();
		
		/*
		System.out.println(":----- STUDENT DETAILS -----:");
		System.out.println("Branch   :  " + s1.getBranch());
		System.out.println("SAP ID   :  " + s1.getSapId());
		System.out.println("Roll No  :  " + s1.getRollNo());
		System.out.println("Batch  	 :  " + s1.getBatch());
		System.out.println("Name     :  " + s1.getName());
		System.out.println("CGPA     :  " + s1.getCgpa());
		System.out.println();
		System.out.println("Branch Validation : " + s1.getBranchValidationFlag());
		System.out.println("SAPID Validation : " + s1.getSapidValidationFlag());
		System.out.println("Roll No Validation : " + s1.getRollnoValidationFlag());
		System.out.println("Batch Validation : " + s1.getBatchValidationFlag());
		System.out.println("Name Validation : " + s1.getNameValidationFlag());
		System.out.println("CGPA Validation : " + s1.getCgpaValidationFlag());*/
		
		boolean final_flag = s1.getBranchValidationFlag() &&
							 s1.getSapidValidationFlag() &&
							 s1.getRollnoValidationFlag() &&
							 s1.getBatchValidationFlag() &&
							 s1.getNameValidationFlag() &&
							 s1.getCgpaValidationFlag();
		
		return final_flag;
	}

}
