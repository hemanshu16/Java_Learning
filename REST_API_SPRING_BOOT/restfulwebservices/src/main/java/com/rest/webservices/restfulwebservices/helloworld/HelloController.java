package com.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private MessageSource messageSource;
	
	public HelloController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@GetMapping(path = "hello-world")
	public String helloWorld()
	{
		return "Hello";
	}
	
	@GetMapping(path="hello-bean")
	public Hello helloBean()
	{
		return new Hello("Hello Message");
	}
	
	@GetMapping(path="hello-bean/{name}")
	public Hello helloBeanBame(@PathVariable String name)
	{
		return new Hello("Hello Message " + name);
	}
	
	@GetMapping(path="internationalization")
	public String internationalization()
	{
//		return "hello";
		Locale locale = LocaleContextHolder.getLocale();
//		return locale.toString();
		return messageSource.getMessage("good.morning.message", null,"Default Message", locale);
	}
}
