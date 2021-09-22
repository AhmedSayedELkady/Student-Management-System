package com.springboot.service;

import java.util.List;

import com.springboot.entity.Student;

public interface StudentService {

	List<Student> getAllStudent(String key);
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudent(Long id);
}
