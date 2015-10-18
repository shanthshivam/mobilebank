package com.tcs.bfscoe.mobilebanking.service.v1;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tcs.bfscoe.mobilebanking.domain.AppRegistration;
import com.tcs.bfscoe.mobilebanking.domain.User;
import com.tcs.bfscoe.mobilebanking.repository.UserRepository;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@Api(value = "referrals", description = "Customer Referrals of their contacts  API")
public class ReferralController {

	@Autowired
	public UserRepository userRepository;

	/**
	 *
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/v1/referrals")
	@ApiOperation(value = "Retrieves all users")
	public ResponseEntity<Iterable<User>> getAllUsers() {

		Iterable<User> allUsers = userRepository.findAll();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}

	/**
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/v1/referrals/{id}")
	@ApiOperation(value = "Retrieves a User associated with the user id", response = User.class)
	public ResponseEntity<User> getUserDetails(@PathVariable("id") String id) {

		User user = userRepository.findOne(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	/**
	 * 
	 * @param users
	 * @return
	 */
	@ApiOperation(value = "Send a list of user details of the people being referred.")
	@RequestMapping(method = RequestMethod.POST, value = "/v1/referrals", consumes = "application/json")
	public ResponseEntity<?> createUsers(@Valid @RequestBody List<User> users) {

		List<String> response = new ArrayList<String>();
		// Set the location header for the newly created resource
		HttpHeaders responseHeaders = new HttpHeaders();

		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			userRepository.save(user);
			response.add("Added " + user.toString());


		}
		URI newUserUri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
		responseHeaders.setLocation(newUserUri);
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}

}
