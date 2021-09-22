package com.springboot.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.entity.Student;
import com.springboot.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public String listAllStudents(Model model,@Param("key") String key) {
		model.addAttribute("students", studentService.getAllStudent(key)); /* model */
		return "students"; /* view */
	}

	@GetMapping("/students/new")
	public String createStudent(Model model) {
		/* this Student object to hold student data */
		Student s = new Student();
		model.addAttribute("student", s);
		return "createStudents";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student){/*@ModelAttribute is to bind data to object*/
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id ,Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return"editStudent";
	}
	
	@PostMapping("/students/{id}")
	public String UpdateStudent(@PathVariable Long id,@ModelAttribute("student") Student student,Model model) {
		
		/*first get Student from database */
		Student dbStudent = studentService.getStudentById(id);
		dbStudent.setId(id);
		dbStudent.setFirstName(student.getFirstName());
		dbStudent.setLastName(student.getLastName());
		dbStudent.setEmail(student.getEmail());
		dbStudent.setTown(student.getTown());
		
		/*now save the new data of the student*/
		studentService.updateStudent(dbStudent);
		
		return"redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudents(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return"redirect:/students";
	}
}
