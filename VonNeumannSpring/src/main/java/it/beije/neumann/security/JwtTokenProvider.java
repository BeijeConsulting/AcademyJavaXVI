package it.beije.neumann.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import it.beije.neumann.exception.InvalidJwtAuthenticationException;
import it.beije.neumann.model.User;
import it.beije.neumann.service.UserService;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import java.util.Base64;
import java.util.Date;
import java.util.List;


@Component
public class JwtTokenProvider {    

//	@Value("${authToken.secretKey}")
	private String secretKey = "neumannKey";
	
//	@Value("${authToken.validityInMilliseconds}")
	private long validityInMilliseconds = 3600000; // 1h   


	@Autowired
	private UserService userService;

	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}    

	public String createToken(String username, List<String> roles) {
		Claims claims = Jwts.claims().setSubject(username);
		claims.put("roles", roles);        

		Date now = new Date();
		Date validity = new Date(now.getTime() + validityInMilliseconds);        

		return Jwts.builder()//
				.setClaims(claims)//
				.setIssuedAt(now)//
				.setExpiration(validity)//
				.signWith(SignatureAlgorithm.HS256, secretKey)//
				.compact();
	}


	public Authentication getAuthentication(String token) {
		User user = userService.loadUserByUsername(getUsername(token));
		return new UsernamePasswordAuthenticationToken(user, "", user.getAuthorities());
	}    

	private String getUsername(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}    

	public String resolveToken(HttpServletRequest req) {
		String bearerToken = req.getHeader("Authorization");
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}    

	public boolean validateToken(String token) {
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token); 
			if (claims.getBody().getExpiration().before(new Date())) {
				return false;
			} 
			return true;
		} catch (ExpiredJwtException e) {
	           throw new InvalidJwtAuthenticationException("Expired JWT1 token", InvalidJwtAuthenticationException.EXPIRED);
		} catch (JwtException | IllegalArgumentException e) {
            throw new InvalidJwtAuthenticationException("Invalid JWT3 token", InvalidJwtAuthenticationException.FORBIDDEN);
		}
	}
	
}