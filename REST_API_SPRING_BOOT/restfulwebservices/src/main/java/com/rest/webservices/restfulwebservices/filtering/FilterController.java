package com.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {
	
	@GetMapping("/GetBean")
	public MappingJacksonValue getBean()
	{
		SomeBean someBean = new SomeBean("Field1","Field2","Field3");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		mappingJacksonValue.setFilters(filters );
		return mappingJacksonValue;
	}
	
	@GetMapping("/GetAllBean")
	public MappingJacksonValue getAllBean()
	{
		List<SomeBean> arr = Arrays.asList(new SomeBean("Field1","Field2","Field3"),
				new SomeBean("Field4","Field5","Field6"));
MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(arr);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		mappingJacksonValue.setFilters(filters );
		return mappingJacksonValue;
	}
	
	
	
}
