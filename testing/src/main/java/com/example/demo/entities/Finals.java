package com.example.demo.entities;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Finals {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ledgerId;
	private int studentId;
	private int marks;
	private int totalMarks;
	
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Timestamp timeStamp;
	public Finals() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Finals(int ledgerId, int studentId, int marks, int totalMarks, Timestamp timeStamp) {
		super();
		this.ledgerId = ledgerId;
		this.studentId = studentId;
		this.marks = marks;
		this.totalMarks = totalMarks;
		this.timeStamp = timeStamp;
	}

	public int getLedgerId() {
		return ledgerId;
	}

	public void setLedgerId(int ledgerId) {
		this.ledgerId = ledgerId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
	
}
