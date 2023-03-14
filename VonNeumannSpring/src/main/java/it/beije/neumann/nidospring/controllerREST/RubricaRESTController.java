package it.beije.neumann.nidospring.controllerREST;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.neumann.dto.AuthCredentials;
import it.beije.neumann.exception.InvalidJSONException;
import it.beije.neumann.model.User;
import it.beije.neumann.nidospring.dto.ContactDTO;
import it.beije.neumann.nidospring.model.Contact;
import it.beije.neumann.nidospring.service.ContactService;
import it.beije.neumann.security.JwtTokenProvider;
import it.beije.neumann.service.UserService;

@RestController
@RequestMapping(value = "nidorest")
public class RubricaRESTController {

	@Autowired
	private ContactService contactService;
	
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

	@PreAuthorize("permitAll()")
	@GetMapping(value = "/contacts")
	public List<ContactDTO> showAllContacts(HttpServletRequest request, @RequestParam(required = false) String onWhat, @RequestParam(required = false) String orderBy) {
		System.out.println("GET "+request.getRequestURL());

		return contactService.findBySorted(onWhat, orderBy);
	}

	@PreAuthorize("hasAuthority('USER')")
	@GetMapping(value = "/contact/{id}")
	public Contact contactDetails(HttpServletRequest request, @PathVariable(name = "id") Integer id) {
		System.out.println("GET "+request.getRequestURL());

		return contactService.findContactById(id);

	}
	
	@PreAuthorize("permitAll()")
	@GetMapping(value = "/contact")
	public List<ContactDTO> searchContact(HttpServletRequest request, @RequestParam(required = false) String name, @RequestParam(required = false) String surname) {
		System.out.println("GET "+request.getRequestURL());

		if (surname != null && name != null) return contactService.findContactByFullName(surname, name);
		
		if (surname != null) return contactService.findContactBySurname(surname);

		if (name != null) return contactService.findContactByName(name);
		
		return contactService.findBySorted(null, null);

	}
	
	@PreAuthorize("permitAll()")
	@PostMapping(value="/contact")
	public Contact addContact(HttpServletRequest request, @RequestBody Contact data) {
		System.out.println("POST "+request.getRequestURL());
		
		System.out.println(data);
		if (data.getId()!=null) throw new InvalidJSONException("Non è possibile aggiungere un contatto con ID avvalorato");

		return contactService.saveContact(data);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping(value="/contact/{id}")
	public Contact updateContact(HttpServletRequest request, @PathVariable Integer id, @RequestBody Contact edit) {
		System.out.println("PUT "+request.getRequestURL());
		
		if(id.compareTo(edit.getId()) !=0) throw new InvalidJSONException("Attenzione, gli ID inseriti non corrispondono!");
		
		contactService.updateContact(id, edit);
		
		return edit;
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping(value = "/contact/{id}")
	public Boolean deleteContact(HttpServletRequest request, @PathVariable Integer id) {
		System.out.println("DELETE "+request.getRequestURL());
		return contactService.deleteContact(id);
	}

}
