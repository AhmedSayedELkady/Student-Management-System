package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query("Select s FROM Student s WHERE s.town LIKE %?1%")
	public List<Student> filter(String key) ;
}
