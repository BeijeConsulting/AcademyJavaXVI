package it.beije.neumann.db3.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.db3.model.Address;
import it.beije.neumann.db3.model.User;
import it.beije.neumann.db3.service.AddressService;
import it.beije.neumann.db3.service.UserService;

@Controller
public class AddressController {

	@Autowired
	private UserService userService;

	@Autowired
	private AddressService addressService;

	@RequestMapping(value = { "/db3/addresses" }, method = RequestMethod.GET)
	public String addressesListGet(HttpServletRequest request, Model model) {
		System.out.println("GET /db3/addresses");

		String jsp = "db3/";

		HttpSession session = request.getSession();

		if (userService.isUserLogged(session)) {
			model.addAttribute("logged_user", userService.getLoggedUser(session));
			jsp += "user/addresses";
		} else {
			jsp += "signin";
		}

		return jsp;
	}

	@RequestMapping(value = { "/db3/add_address" }, method = RequestMethod.GET)
	public String addAddressGet(HttpServletRequest request) {
		System.out.println("GET /db3/add_address");

		String jsp = "db3/";
		HttpSession session = request.getSession();

		if (userService.isUserLogged(session)) {
			jsp += "user/add_address";
		} else {
			jsp += "signin";
		}

		return jsp;
	}

	@RequestMapping(value = { "/db3/add_address" }, method = RequestMethod.POST)
	public String addAddressPost(HttpServletRequest request, Model model, Address addressData) {
		System.out.println("POST /db3/add_address");

		HttpSession session = request.getSession();
		addressData.setUserId((userService.getLoggedUser(session)).getId());
		System.out.println(addressData);

		addressService.saveAddress(addressData);

		session.setAttribute("logged_user", userService.findById(addressData.getUserId()));

		return "db3/user/addresses";
	}

	@RequestMapping(value = { "/db3/edit_address/{addressId}" }, method = RequestMethod.GET)
	public String editAddressGet(HttpServletRequest request, Model model, @PathVariable int addressId) {
		System.out.println("GET /db3/edit_address/{addressId}");

		String jsp = "db3/";
		HttpSession session = request.getSession();

		if (userService.isUserLogged(session)) {
			List<Address> addresses = (userService.getLoggedUser(session)).getAddresses();
			Address toEdit = null;

			for (Address a : addresses) {
				if (a.getId() == addressId) {
					toEdit = a;
					break;
				}
			}

			model.addAttribute("address", toEdit);

			jsp += "user/edit_address";
		} else {
			jsp += "signin";
		}

		return jsp;
	}

	@RequestMapping(value = { "/db3/edit_address/{addressId}" }, method = RequestMethod.POST)
	public String editAddressPost(HttpServletRequest request, Model model, Address addressData,
			@PathVariable int addressId) {
		System.out.println("POST /db3/edit_address/{addressId}");

		HttpSession session = request.getSession();

		Address fromDBtoEdit = addressService.findById(addressId);

		fromDBtoEdit.copyValuesOf(addressData);

		addressService.saveAddress(fromDBtoEdit);

		session.setAttribute("logged_user", userService.findById(fromDBtoEdit.getUserId()));

		return "db3/user/addresses";
	}

	@RequestMapping(value = { "/db3/delete_address/{addressId}" }, method = RequestMethod.GET)
	public String deleteAddressGet(HttpServletRequest request, Model model, @PathVariable int addressId) {
		System.out.println("GET /db3/delete_address/{addressId}");

		String jsp = "db3/";

		HttpSession session = request.getSession();

		if (userService.isUserLogged(session)) {
			List<Address> addresses = userService.getLoggedUser(request.getSession()).getAddresses();
			Address toDelete = null;
			
			for (Address a : addresses) {
				if (a.getId() == addressId) {
					toDelete = a;
					break;
				}
			}
			
			model.addAttribute("address", toDelete);
			
			jsp += "user/delete_address";
		} else {
			jsp += "signin";
		}
		

		return jsp;
	}

	@RequestMapping(value = { "/db3/delete_address/{addressId}" }, method = RequestMethod.POST)
	public String deleteAddressPost(HttpServletRequest request, Model model, @PathVariable int addressId) {
		System.out.println("POST /db3/delete_address/{addressId}");

		System.out.println("deleting -> " + addressId);

		HttpSession session = request.getSession();

		Address toDisable = addressService.findById(addressId);

		toDisable.setDisabledAt(LocalDateTime.now());

		addressService.saveAddress(toDisable);

		session.setAttribute("logged_user", userService.findById(toDisable.getUserId()));

		return "db3/user/addresses";
	}

}
