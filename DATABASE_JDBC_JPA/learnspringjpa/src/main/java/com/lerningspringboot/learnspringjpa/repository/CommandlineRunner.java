package com.lerningspringboot.learnspringjpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lerningspringboot.learnspringjpa.models.Course;

@Component
public class CommandlineRunner implements CommandLineRunner{

//	@Autowired
//	private Springjdbc springJdbc;
	
//	@Autowired
//	private SpringJPA springJPA;
	
	@Autowired
	private CourseSpringJpaRepository springJPA;
	
	@Override
	public void run(String... args) throws Exception {
	
//		springJdbc.insert(new Course(1,"learn Java","in28minutes"));
//		springJdbc.insert(new Course(2,"learn Java spring","in28minutes"));
//		springJdbc.insert(new Course(3,"learn Java jdbc","in28minutes"));
//		
//		springJdbc.delete(2);
//		System.out.println(springJdbc.get_data(1));
//		System.out.println(springJdbc.get_data(3));
		
//		springJPA.insert(new Course(1,"learn Java","in28minutes"));
//		springJPA.insert(new Course(2,"learn Java spring","in28minutes"));
//		springJPA.insert(new Course(3,"learn Java jdbc","in28minutes"));
//		
//		springJPA.delete(2);
//		System.out.println(springJPA.get_data(1));
//		System.out.println(springJPA.get_data(3));
		
		springJPA.save(new Course(1,"learn Java","in28minutes"));
		springJPA.save(new Course(2,"learn Java spring","in28minutes"));
		springJPA.save(new Course(3,"learn Java jdbc","in28minutes"));
		
		springJPA.deleteById(2);
		System.out.println(springJPA.findById(1));
		System.out.println(springJPA.findById(3));
		System.out.println(springJPA.findByAuthor("in28minutes"));
		System.out.println(springJPA.findByName("learn Java"));
		System.out.println(springJPA.findAll());
	
		
	}

}
