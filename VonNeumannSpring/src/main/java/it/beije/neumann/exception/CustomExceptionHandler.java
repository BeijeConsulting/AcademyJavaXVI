package it.beije.neumann.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/*	RIEPILOGO GESTIONE ECCEZIONI:
 * 
 * InvalidJSONException  				400
 * DBException 							503
 * UsernameNotFoundException 			401
 * InvalidJwtAuthenticationException  	401
 * BadCredentialsException  			401
 * ForbiddenException					403
 */


@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());


//	@ExceptionHandler(value = {UsernameNotFoundException.class})
//	public ResponseEntity<ErrorMessage> ControllerExceptionHandler(UsernameNotFoundException ex, WebRequest request) {
//		int errorCode = 401;
//		ErrorMessage re = new ErrorMessage();
//		re.setMessage(ex.getLocalizedMessage());
//		re.setStatus(errorCode);
//		re.setTime(LocalDateTime.now());
//		log.error(re.getMessage());
//		return ResponseEntity.status(errorCode).body(re);
//	}
	
//	@ExceptionHandler(value = {InvalidJwtAuthenticationException.class})
//	public ResponseEntity<ErrorMessage> ControllerExceptionHandler(InvalidJwtAuthenticationException ex, WebRequest request) {
//		int errorCode = ex.getCode();
//		ErrorMessage re = new ErrorMessage();
//		re.setMessage(ex.getLocalizedMessage());
//		re.setStatus(errorCode);
//		re.setTime(LocalDateTime.now());
//		log.error(re.getMessage());
//		return ResponseEntity.status(errorCode).body(re);
//	}
	
//	@ExceptionHandler(value = {BadCredentialsException.class})
//	public ResponseEntity<ErrorMessage> ControllerExceptionHandler(BadCredentialsException ex, WebRequest request) {
//		int errorCode = 401;
//		ErrorMessage re = new ErrorMessage();
//		re.setMessage(ex.getLocalizedMessage());
//		re.setStatus(errorCode);
//		re.setTime(LocalDateTime.now());
//		log.error(re.getMessage());
//		return ResponseEntity.status(errorCode).body(re);
//	}

	@ExceptionHandler(value = {NeumannException.class})
	public ResponseEntity<ErrorMessage> ControllerExceptionHandler(NeumannException ex, WebRequest request) {
		int errorCode = 400;
		ErrorMessage re = new ErrorMessage();
		re.setMessage(ex.getLocalizedMessage());
		re.setStatus(errorCode);
		re.setTime(LocalDateTime.now());
		log.error(re.getMessage());
		return ResponseEntity.status(errorCode).body(re);
	}

	@ExceptionHandler(value = {IdNotFoundException.class})
	public ResponseEntity<ErrorMessage> ControllerExceptionHandler(IdNotFoundException ex, WebRequest request) {
		int errorCode = 404;
		ErrorMessage re = new ErrorMessage();
		re.setMessage(ex.getLocalizedMessage());
		re.setStatus(errorCode);
		re.setTime(LocalDateTime.now());
		log.error(re.getMessage());
		return ResponseEntity.status(errorCode).body(re);
	}

	@ExceptionHandler(value = {ForbiddenException.class})
	public ResponseEntity<ErrorMessage> ControllerExceptionHandler(ForbiddenException ex, WebRequest request) {
		int errorCode = 403;
		ErrorMessage re = new ErrorMessage();
		re.setMessage(ex.getLocalizedMessage());
		re.setStatus(errorCode);
		re.setTime(LocalDateTime.now());
		log.error(re.getMessage());
		return ResponseEntity.status(errorCode).body(re);
	}

	@ExceptionHandler(value = {InvalidJSONException.class})
	public ResponseEntity<ErrorMessage> ControllerExceptionHandler(InvalidJSONException ex, WebRequest request) {
		int errorCode = 400;
		ErrorMessage re = new ErrorMessage();
		re.setMessage(ex.getLocalizedMessage());
		re.setStatus(errorCode);
		re.setTime(LocalDateTime.now());
		log.error(re.getMessage());
		return ResponseEntity.status(errorCode).body(re);
	}

	@ExceptionHandler(value = {DBException.class})
	public ResponseEntity<ErrorMessage> ControllerExceptionHandler(DBException ex, WebRequest request) {
		int errorCode = 503;
		ErrorMessage re = new ErrorMessage();
		re.setMessage(ex.getLocalizedMessage());
		re.setStatus(errorCode);
		re.setTime(LocalDateTime.now());
		log.error(re.getMessage());
		return ResponseEntity.status(errorCode).body(re);
	}

}