package com.ganesh.entity;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String mobileNo;
	
	private String gender;
	
	private String dob;
	
	private String department;
	
	private String course;
	
	@CreationTimestamp
	private String registerDate;
	
	private Integer sscMarks;
	
	private Integer hscMarks;
	
	private String address;
	
	private Integer age;

}
