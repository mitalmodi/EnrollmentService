/**
 * 
 */
package coder.challenge.app.enrollment.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import coder.challenge.app.enrollment.error.EnrollmentError;
import coder.challenge.app.enrollment.exception.EnrollmentException;

/**
 * @author v.huggila
 *
 */
@ControllerAdvice
public class EnrollmentExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EnrollmentException.class)
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return super.handleExceptionInternal(ex, new EnrollmentError(ex.getMessage(), 1001), new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

}
