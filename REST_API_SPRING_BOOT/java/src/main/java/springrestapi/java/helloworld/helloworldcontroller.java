package springrestapi.java.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import userexception.Usernotfoundexception;

@RestController
public class helloworldcontroller {
         
	@GetMapping(path = "/hello")
	public String helloworld()
	{
		if(true) {
	     throw new ArithmeticException("not vali");
		}
		return "Hi Hello World";
	}
}
