package com.example.demo.entities;

public class ObjWrapper{
	private Student student;
	private Finals finals;
	
	
	public ObjWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ObjWrapper(Student student, Finals finals) {
		super();
		this.student = student;
		this.finals = finals;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Finals getFinals() {
		return finals;
	}
	public void setFinals(Finals finals) {
		this.finals = finals;
	}
	
	
}
