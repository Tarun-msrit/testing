package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRepo;
import com.example.demo.entities.Student;

@Service
public class StudentService {
	
	@Autowired
	public StudentRepo studRepository;
	
	public List<Student> getStudent() {
		return studRepository.findAll();
	}
	public Optional<Student> getStudentById(int id) {
		return studRepository.findById(id);
	}
	
	public void updateStudent(int id,int marks) {
	Optional<Student> optional = studRepository.findById(id);
	Student student = optional.get();
		student.setMarks(marks);
		studRepository.save(student);
		System.out.println("Updated");
	}
	
	public List<Student> getAllBooks(){
		return studRepository.findAll();
		
	}
	
}
	
