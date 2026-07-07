package com.ganesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
