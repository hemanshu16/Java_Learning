package springrestapi.java.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworldcontroller {
         
	@RequestMapping(method = RequestMethod.GET,path = "/hello")
	public String helloworld()
	{
		return "Hi Hello World";
	}
}
