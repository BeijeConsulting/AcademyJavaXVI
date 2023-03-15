package it.beije.neumann.nidospring.controllerREST;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.neumann.dto.AuthCredentials;
import it.beije.neumann.model.User;
import it.beije.neumann.security.JwtTokenProvider;
import it.beije.neumann.service.UserService;

@RestController
@RequestMapping(value = "ecom")
public class EcommerceRESTController {
	
	//<Accesso>
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private UserService userService;
	
	@PreAuthorize("permitAll()")
	@PostMapping("/signin")
	public ResponseEntity<Map<String, Object>> signin(HttpServletRequest request,@RequestBody AuthCredentials credentials) throws RuntimeException {
		System.out.println("POST "+request.getRequestURL());

		try {
			String email = credentials.getEmail();
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, credentials.getPassword()));
			User user = userService.loadUserByUsername(email);
			
			String token = jwtTokenProvider.createToken(email, user.getAuthorityList());

			Map<String, Object> res = new HashMap<>();
			res.put("email", email);
			res.put("permission", user.getAuthorityList());
			res.put("token", token);
			res.put("id", user.getId());

			return ok(res);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			throw new BadCredentialsException("Email o password non validi :(");
		} catch (RuntimeException e) {
			throw e;
		}
	}
	//</Accesso>
	
	

}
