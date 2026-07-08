package com.ganesh.Dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentDto {
	
	
	
	
	private Integer id;
	
	@NotNull(message = "First Name is Required")
	private String firstName;
	
	@NotNull(message = "Last Name is Required")
	private String lastName;

	@NotNull(message = "Email is Required")
	private String email;
	
	@NotNull(message = "Mobile No is Required")
	private String mobileNo;
	
	@NotNull(message = "Date of Birth is Required")
	private String dob;
	
	@NotNull(message = "Department is Required")
	private String department;
	
	@NotNull(message = "Course is Required")
	private String course;
	
	private String registerDate;
	
	@NotNull(message = "SSC Marks is Required")
	private Integer sscMarks;
	
	@NotNull(message = "HSC Marks is Required")
	private Integer hscMarks;
	
	@NotNull(message = "Address is Required")
	private String address;
	
	@NotNull(message = "Age is Required")
	private Integer age;

}
