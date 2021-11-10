package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.FinalsRepo;
import com.example.demo.entities.Finals;


public class FinalsService {
	
	@Autowired
	public FinalsRepo finalsRepository;
	
	public void createFinals(Finals finals,int studentId,int marks,int totalMarks) {
		finals.setStudentId(studentId);
		finals.setMarks(marks);
		finals.setTotalMarks(totalMarks);
		finalsRepository.save(finals);
	}
}
