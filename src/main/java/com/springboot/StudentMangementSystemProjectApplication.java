package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.entity.Student;
import com.springboot.repository.StudentRepository;

@SpringBootApplication
public class StudentMangementSystemProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentMangementSystemProjectApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Student s1 = new Student("Ahmed" ,"ELkady" ,"elkady@gmail.com");
		 * studentRepository.save(s1); Student s2 = new Student("Mohamed" ,"kamel"
		 * ,"hegz@gmail.com"); studentRepository.save(s2);
		 */
	}

}
