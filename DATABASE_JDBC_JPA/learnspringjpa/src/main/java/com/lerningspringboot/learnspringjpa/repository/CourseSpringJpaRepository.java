package com.lerningspringboot.learnspringjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lerningspringboot.learnspringjpa.models.Course;

public interface CourseSpringJpaRepository extends JpaRepository<Course, Integer>{

	List<Course> findByName(String name);
	List<Course> findByAuthor(String authore);
}
