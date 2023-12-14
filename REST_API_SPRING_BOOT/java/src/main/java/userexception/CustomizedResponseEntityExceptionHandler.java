package userexception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import error.Errordetails;

/*
 * giving controlleradvice this class component become global object which handle
 * all exception 
 * for that purpose we are extends ResonseEntityExceptionHandler
 * so default feature remain as it
 * now in case error, exception
 * we want to define our own structure or for particular user defined exception
 * we want to take action , give different status code that thing we can do
 * first two methods through
 * and last method is for validation errors.
 */
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Errordetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		Errordetails Error = new Errordetails(LocalDateTime.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<Errordetails>(Error, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	/*
	 * some exception is thrown and for particular exception userdefined
	 * userdefined action is taken
	 * for that purpose we are defining below mthod
	 * status code and error structure we want to define that we are telling.
	 */
//	@ExceptionHandler(UserNotFoundException.class)
//	public final ResponseEntity<Error> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
//		Error Error = new Error(LocalDateTime.now(), 
//				ex.getMessage(), request.getDescription(false));
//		
//		return new ResponseEntity<Error>(Error, HttpStatus.NOT_FOUND);
//		
//	}
	/*
	 * while in case validation of our api request
	 * input data in body is not valid in that case
	 * while data binded to our object from request body to object
	 * that time validataion applied which are defined in model class pojo
	 * not valid then we want to say user not valid data 
	 * 	BAD REQUEST	
	 * in that case our global exception handler class
	 * @ControllerAdvice 
	 * will receive exception 
	 * we are defining our own method for sending custome message structure in response
	 * other default message is that bad request
	 * but we are developing rest api so customer want to know what is mistakes
	 * for that purpose we are writing specific validation error in response
	 * all this done by below method which we are overriding
	 */
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(
//			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//		
//		StringBuilder errors = new StringBuilder("");
//		for(FieldError error : ex.getFieldErrors())
//		{
//			errors.append(error.getDefaultMessage());
//		}
//		Error Error = new Error(LocalDateTime.now(), 
//				"Total Errors:" + ex.getErrorCount() + " Errors " + errors.toString(), request.getDescription(false));
//		
//		
//		
//		return new ResponseEntity(Error, HttpStatus.BAD_REQUEST);
//	}

}