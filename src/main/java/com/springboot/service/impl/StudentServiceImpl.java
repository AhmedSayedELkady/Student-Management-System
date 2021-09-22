package com.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.entity.Student;
import com.springboot.repository.StudentRepository;
import com.springboot.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentReposirtory;

	public StudentServiceImpl(StudentRepository studentReposirtory) {
		super();
		this.studentReposirtory = studentReposirtory;
	}

	@Override
	public List<Student> getAllStudent(String key) {
		if (key != null) {
			return studentReposirtory.filter(key);
		} else {
			return studentReposirtory.findAll();
		}
	}

	@Override
	public Student saveStudent(Student student) {
		return studentReposirtory.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentReposirtory.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentReposirtory.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		studentReposirtory.deleteById(id);

	}

}
