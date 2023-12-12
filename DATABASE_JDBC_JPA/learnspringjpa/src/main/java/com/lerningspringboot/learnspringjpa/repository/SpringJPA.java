package com.lerningspringboot.learnspringjpa.repository;

import org.springframework.stereotype.Repository;

import com.lerningspringboot.learnspringjpa.models.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SpringJPA {
   
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert (Course course)
	{
		entityManager.merge(course);
	}
	
	public Course get_data(int id)
	{
		return entityManager.find(Course.class, id);
	}
	public void delete(int id)
	{
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
}
