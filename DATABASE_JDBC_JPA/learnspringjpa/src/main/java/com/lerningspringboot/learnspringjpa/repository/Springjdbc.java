package com.lerningspringboot.learnspringjpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lerningspringboot.learnspringjpa.models.Course;

@Repository
public class Springjdbc {
   
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String query = """ 
			 insert into course (id,name,author)
			  values(?,?,?)
			""";
	private static String deletequery = """ 
				delete from course where id = ?;
			""";
	
	private static String selectquery = """ 
				select * from course where id = ?;
			""";
	public void insert(Course course)
	{
		springJdbcTemplate.update(query,course.getId(),course.getName(),course.getAuthor());
	}
	
	public void delete(int id)
	{
		springJdbcTemplate.update(deletequery,id);
	}
	
	public Course get_data(int id)
	{
		return springJdbcTemplate.queryForObject(selectquery,new BeanPropertyRowMapper<>(Course.class),id);
	}
}
