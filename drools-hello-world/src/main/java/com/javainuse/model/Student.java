package com.javainuse.model;

public class Student {

	// input class variables
	private String name;
	private String dob;
	private long sapid;
	private String rollno;
	private String branch;
	private float cgpa;
	// class variable we will set according to rules defined
	private String stuType;

	// methods related to Student Name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// methods related to Student DOB
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	// methods related to Student SapId
	public long getSapId() {
		return sapid;
	}

	public void setSapId(long sapid) {
		this.sapid = sapid;
	}

	// methods related to Student RollNo
	public String getRollNo() {
		return rollno;
	}

	public void setRollNo(String rollno) {
		this.rollno = rollno;
	}

	// methods related to Student Branch
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	// methods related to Student CGPA
	public float getCgpa() {
		return cgpa;
	}

	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}

	// methods related to Student Type
	public String getStuType() {
		return stuType;
	}

	public void setStuType(String stuType) {
		this.stuType = stuType;
	}

}