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

	public static void main(String[] args) throws DroolsParserException, IOException {
		DroolsStudent droolsTest = new DroolsStudent();
		droolsTest.executeDrools();
	}

	public void executeDrools() throws DroolsParserException, IOException {

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
		s1.setName("Anchit Gupta");
		s1.setDob("22-02-1999");
		s1.setSapId(500063399);
		s1.setRollNo("R103217016");
		s1.setBranch("CSE-BAO");
		s1.setCgpa(8.87f);
		workingMemory.insert(s1);
		workingMemory.fireAllRules();

		System.out.println(":----- STUDENT DETAILS -----:");
		System.out.println("Name     :  " + s1.getName());
		System.out.println("D.O.B  	 :  " + s1.getDob());
		System.out.println("SAP ID   :  " + s1.getSapId());
		System.out.println("Roll No  :  " + s1.getRollNo());
		System.out.println("Branch   :  " + s1.getBranch());
		System.out.println("CGPA     :  " + s1.getCgpa());
		System.out.println("The above student has been categorized as a '" + s1.getStuType() + "'");
	}

}
