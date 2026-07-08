package com.ganesh.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.Dto.StudentDto;
import com.ganesh.entity.Student;
import com.ganesh.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/student")
public class StudentRestController {
	
	
	private final StudentService studentService;
	
	public StudentRestController(StudentService studentService) {
		
		this.studentService=studentService;
	}
	
	
	
	@PostMapping("/save")
	public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto) {
		
		StudentDto saveStudent = studentService.saveStudent(studentDto);
		
		return new ResponseEntity<StudentDto>(saveStudent, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> findAllStudents() {
		
		List<Student> allStudents = studentService.findAllStudents();
		
		return new ResponseEntity<List<Student>>(allStudents, HttpStatus.OK);
	}

	
	@GetMapping("/byid/{id}")
	public ResponseEntity<Student> findStudentById(@PathVariable Integer id) {
		
		Student studentById = studentService.findStudentById(id);
		
		return new ResponseEntity<Student>(studentById, HttpStatus.OK);
	}
}
