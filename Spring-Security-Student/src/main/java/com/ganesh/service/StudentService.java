package com.ganesh.service;

import java.util.List;

import com.ganesh.Dto.StudentDto;
import com.ganesh.entity.Student;

public interface StudentService {
	
	
	StudentDto saveStudent(StudentDto studentDto);
	
	List<Student> findAllStudents();
	
	Student findStudentById(Integer id);

}
