package com.ganesh.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ganesh.Dto.StudentDto;
import com.ganesh.entity.Student;
import com.ganesh.exception.StudentNotFoundException;
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


	@Override
	public Student findStudentById(Integer id) {
		
		Optional<Student> byId = studentRepository.findById(id);
		
		if (byId.isPresent()) {
			
			Student student = byId.get();
			
			return student;
		}

	    throw new StudentNotFoundException("Student Not Found With Id = "+id); 
	}


	@Override
	public String updateStudentById(Integer id, Student student) {

		Optional<Student> byId = studentRepository.findById(id);
		
		if (byId.isPresent()) {
			
			Student existing = byId.get();
			
			existing.setFirstName(student.getFirstName());
			existing.setFirstName(student.getFirstName());
			existing.setLastName(student.getLastName());
			existing.setEmail(student.getEmail());
			existing.setMobileNo(student.getMobileNo());
			existing.setGender(student.getGender());
			existing.setDob(student.getDob());
			existing.setDepartment(student.getDepartment());
			existing.setCourse(student.getCourse());
			existing.setRegisterDate(student.getRegisterDate());
			existing.setSscMarks(student.getSscMarks());
			existing.setHscMarks(student.getHscMarks());
			existing.setAddress(student.getAddress());
			existing.setAge(student.getAge());
			
			studentRepository.save(existing);
			
			return "Student Update Success";
		}
		
		throw new StudentNotFoundException("Student Not Found With Id = "+id);
	}


	@Override
	public String deleteStudentById(Integer id) {
		
		if (studentRepository.existsById(id)) {
			
			studentRepository.deleteById(id);
			
			return "Student Delete Success";
		}
		throw new StudentNotFoundException("Student Not Found With Id = "+id);
	}

}
