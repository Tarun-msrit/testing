package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.FinalsRepo;
import com.example.demo.dao.StudentRepo;
import com.example.demo.entities.Finals;
import com.example.demo.entities.ObjWrapper;
import com.example.demo.entities.Student;
import com.example.demo.services.FinalsService;
import com.example.demo.services.StudentService;

@RestController
public class MainController {

	@Autowired
	public StudentRepo studRepository;
	
	@Autowired
	public StudentService studService;
	
	@Autowired
	public FinalsRepo finalsRepository;
	
	public FinalsService finalsService;
	
	
	@GetMapping("/getstudent/{id}")
	public Optional<Student> getStudent(@PathVariable int id){
		return studService.getStudentById(id);
		
	}
	
	@PutMapping(value="/updatemarks/{studentId}/{marks}")
	public ResponseEntity<String> putTables(@PathVariable(value = "studentId") int studentId,@PathVariable(value = "marks") int marks) {
		Optional<Student> optional = studRepository.findById(studentId);
		Student s = optional.get();
	
		int studentMark = s.getMarks();
		int newMarks = studentMark + marks;
		
		Finals finals = new Finals();
		finals.setStudentId(studentId);
		finals.setMarks(marks);
		finals.setTotalMarks(newMarks);
		finalsRepository.save(finals);
//		finalsService.createFinals(finals, studentId, marks, newMarks);
		
		s.setMarks(newMarks);
		
	
		Student saved = studRepository.save(s);
//		return ResponseEntity.ok().body(saved);
		return new ResponseEntity<>(
		          "Marks Updated..total marks is"+newMarks, 
		          HttpStatus.OK);
	}
	
	@GetMapping("/findstudents")
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> allBooks = studService.getAllBooks();
		if(allBooks.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok().body(allBooks);
	}
	
	@GetMapping("/hello")
	public String getHello() {
		return "Hello Tarun,how are you";
	}
	
	@GetMapping("/toys")
	public String getToys() {
		return "Toy";
	}
	@GetMapping("/veggies")
	public String getVeggies() {
		return "Potato";
	}
	@GetMapping("/fruits")
	public String getFruits() {
		return "Mango,Apple";
	}

	@GetMapping("/books")
	public String getBooks(){
		return "Shakespeare";
	}
}