package com.javainuse.model;

public class Student {

	// input class variables
	private String branch;
	private long sapid;
	private String rollno;
	private int batch;
	private String name;
	private float cgpa;

	private boolean branchValidationFlag;
	private boolean sapidValidationFlag;
	private boolean rollnoValidationFlag;
	private boolean batchValidationFlag;
	private boolean nameValidationFlag;
	private boolean cgpaValidationFlag;

	// methods related to Student Name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// methods related to Student DOB
	public String getBatch() {
		return String.valueOf(batch);
	}

	public void setBatch(int batch) {
		this.batch = batch;
	}

	// methods related to Student SapId
	public String getSapId() {
		return String.valueOf(sapid);
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
	public String getCgpa() {
		return String.valueOf(cgpa);
	}

	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}

	// NAME
	public boolean getNameValidationFlag() {
		return nameValidationFlag;
	}

	public void setNameValidationFlag(String flag) {
		this.nameValidationFlag = Boolean.parseBoolean(flag);
	}
	// BATCH
	public boolean getBatchValidationFlag() {
		return batchValidationFlag;
	}

	public void setBatchValidationFlag(String flag) {
		this.batchValidationFlag = Boolean.parseBoolean(flag);
	}
	// SAPID
	public boolean getSapidValidationFlag() {
		return sapidValidationFlag;
	}

	public void setSapidValidationFlag(String flag) {
		this.sapidValidationFlag = Boolean.parseBoolean(flag);
	}
	//ROLL NO
	public boolean getRollnoValidationFlag() {
		return rollnoValidationFlag;
	}

	public void setRollnoValidationFlag(String flag) {
		this.rollnoValidationFlag = Boolean.parseBoolean(flag);
	}
	// BRANCH
	public boolean getBranchValidationFlag() {
		return branchValidationFlag;
	}

	public void setBranchValidationFlag(String flag) {
		this.branchValidationFlag = Boolean.parseBoolean(flag);
	}
	// CGPA
	public boolean getCgpaValidationFlag() {
		return cgpaValidationFlag;
	}

	public void setCgpaValidationFlag(String flag) {
		this.cgpaValidationFlag = Boolean.parseBoolean(flag);
	}

}