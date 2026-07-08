package com.ganesh.service.imp;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ganesh.Dto.StudentDto;
import com.ganesh.entity.Student;
import com.ganesh.repository.StudentRepository;
import com.ganesh.service.StudentService;

@Service
public class StudentServiceImp implements StudentService{
	
	
	private final StudentRepository studentRepository;
	
	public StudentServiceImp(StudentRepository studentRepository) {
		
		this.studentRepository=studentRepository;
	}
	

	@Override
	public StudentDto saveStudent(StudentDto studentDto) {

		Student student=new Student();
		
		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		student.setEmail(studentDto.getEmail());
		student.setMobileNo(studentDto.getMobileNo());
		student.setGender(studentDto.getGender());
		student.setDob(studentDto.getDob());
		student.setDepartment(studentDto.getDepartment());
		student.setCourse(studentDto.getCourse());
		student.setSscMarks(studentDto.getSscMarks());
		student.setHscMarks(studentDto.getHscMarks());
		student.setAddress(studentDto.getAddress());
		student.setAge(studentDto.getAge());
		
		Student saved = studentRepository.save(student);
		
		studentDto.setId(saved.getId());
		studentDto.setFirstName(saved.getFirstName());
		studentDto.setLastName(saved.getLastName());
		studentDto.setEmail(saved.getEmail());
		studentDto.setMobileNo(saved.getMobileNo());
		studentDto.setGender(saved.getGender());
		studentDto.setDob(saved.getDob());
		studentDto.setDepartment(saved.getDepartment());
		studentDto.setCourse(saved.getCourse());
		studentDto.setRegisterDate(saved.getRegisterDate());
		studentDto.setSscMarks(saved.getSscMarks());
		studentDto.setHscMarks(saved.getHscMarks());
		studentDto.setAddress(saved.getAddress());
		studentDto.setAge(saved.getAge());
		
		return studentDto;
	}


	@Override
	public List<Student> findAllStudents() {
		
		return studentRepository.findAll();	
	}

}
