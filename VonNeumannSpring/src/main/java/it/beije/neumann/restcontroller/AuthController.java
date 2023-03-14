package it.beije.neumann.restcontroller;

import static org.springframework.http.ResponseEntity.ok;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.neumann.dto.AuthCredentials;
import it.beije.neumann.exception.NeumannException;
import it.beije.neumann.model.User;
import it.beije.neumann.security.JwtTokenProvider;
import it.beije.neumann.service.UserService;

//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;


@RestController
public class AuthController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private UserService userService;

//	@Autowired
//	private RefreshTokenService refreshTokenService;


	@PreAuthorize("permitAll()")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		System.out.println("GET / ");
		return "index";
	}	

	@PreAuthorize("permitAll()")
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public @ResponseBody String error() throws UnknownHostException {

		System.out.println("GET /error");
		
		if (true) throw new NeumannException("questo e' un problema");

		return "NEUMANN PROJECT";
	}

	@PreAuthorize("hasAuthority('USER')")
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody String test(Authentication auth) {

		System.out.println("GET /test");
		
		User user = (User) auth.getPrincipal();
		
		System.out.println("user : " + user.getEmail() + " " + user.getId());

		return "OK!";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/testadmin", method = RequestMethod.GET)
	public @ResponseBody String testAdmin() throws UnknownHostException {

		System.out.println("GET /testadmin");

		return "OK!";
	}

//	@ApiOperation(value = "signin() --> authority: null, mustBeLogged: no", response = Iterable.class)
//	@ApiResponses(value = {@ApiResponse(code = 401, message = "Invalid email/password supplied"), @ApiResponse(code = 400, message = "User disabled")})
	@PreAuthorize("permitAll()")
	@PostMapping("/signin")
	public ResponseEntity<Map<String, Object>> signin(@RequestBody AuthCredentials credentials) throws RuntimeException {
		System.out.println("POST signin");

		try {
			String email = credentials.getEmail();
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, credentials.getPassword()));
			User user = userService.loadUserByUsername(email);

			// user deactivated
//			if( user.getDisableDate() != null )
//				throw new OnlusException("User has been deleted");
			
			String token = jwtTokenProvider.createToken(email, user.getAuthorityList());

			//RefreshToken refreshToken = refreshTokenService.createRefreshToken(user);

			Map<String, Object> res = new HashMap<>();
			res.put("email", email);
			res.put("permission", user.getAuthorityList());
			res.put("token", token);
			//res.put("refreshToken", refreshToken.getRefreshToken());
			res.put("id", user.getId());

			return ok(res);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			throw new BadCredentialsException("Invalid email/password supplied");
		} catch (RuntimeException e) {
			throw e;
		}
	}

//	@PreAuthorize("permitAll()")
//	@PostMapping("/updateAuthToken")
//	public ResponseEntity<Map<String, Object>> reSignin(@RequestBody RefreshToken refreshToken){
//		System.out.println("POST /updateAuthToken");
//		try {
//			return this.signin(refreshTokenService.getAuthenticationFromRefreshToken(refreshToken.getRefreshToken()));
//		} catch (RuntimeException e) {
//			throw e;
//		}
//	}

}
