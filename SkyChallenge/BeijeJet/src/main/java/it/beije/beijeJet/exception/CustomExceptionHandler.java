package it.beije.beijeJet.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import it.beije.shoes.exception.ErrorMessage;

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


	@ExceptionHandler(value = { BeijeJetException.class })
	public ResponseEntity<ErrorMessage> ControllerExceptionHandler(BeijeJetException ex, WebRequest request) {
		int errorCode = 400;
		ErrorMessage re = new ErrorMessage();
		re.setMessage(ex.getLocalizedMessage());
		re.setStatus(errorCode);
		re.setTime(LocalDateTime.now());
		log.error(re.getMessage());
		return ResponseEntity.status(errorCode).body(re);
	}

	

}