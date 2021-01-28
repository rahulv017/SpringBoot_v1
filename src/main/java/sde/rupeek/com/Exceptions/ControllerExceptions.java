package sde.rupeek.com.Exceptions;
import sde.rupeek.com.Model.ApiError;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptions extends ResponseEntityExceptionHandler{
	
	@Override
	   protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	       String error = "Malformed JSON request";
	       return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
	   }

	   private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
	       return new ResponseEntity<>(apiError, apiError.getStatus());
	   }
	   
	   @Override
	   protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex,
               HttpHeaders headers,
               HttpStatus status,
               WebRequest request)
	   {
		   String error="Please specify correct parameters";
		   return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
		   
	   }
	   
	   @Override
	   @ExceptionHandler(value 
			      = { IllegalArgumentException.class, IllegalStateException.class })
	   protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
               @Nullable
               Object body,
               HttpHeaders headers,
               HttpStatus status,
               WebRequest request)
	   {
		   String error="Please specify correct parameters";
		   return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
	   }
	   
	   @ExceptionHandler(EntityNotFoundException.class)
	   protected ResponseEntity<Object> handleEntityNotFound(
	           EntityNotFoundException ex) {
		   String error="No entry in the database for corresponding value";
		   return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, error, ex));
	   }

	
	

}
