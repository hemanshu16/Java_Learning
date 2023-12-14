package userexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class Usernotfoundexception extends RuntimeException {
		
	public Usernotfoundexception(String message)
	{
		super(message);
	}
}
