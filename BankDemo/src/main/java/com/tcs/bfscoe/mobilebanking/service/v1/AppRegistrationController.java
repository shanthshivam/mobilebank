package com.tcs.bfscoe.mobilebanking.service.v1;

import java.net.URI;

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
import com.tcs.bfscoe.mobilebanking.domain.OTP;
import com.tcs.bfscoe.mobilebanking.repository.AppRegistrationRepository;
import com.tcs.bfscoe.mobilebanking.security.OTPGenerator;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@Api(value = "App Registration", description = "Application Registration  API")
public class AppRegistrationController {

	@Autowired
	public AppRegistrationRepository appRegRepository;

	@ApiOperation(value = "Send the DeviceID for registrating the App", response = Void.class)
	@RequestMapping(method=RequestMethod.POST, value = "/v1/registerapp/{deviceId}")
	public ResponseEntity<?> registerDevice(@PathVariable("deviceId") String deviceId) { 
		
		AppRegistration appRegistration = new AppRegistration();
		appRegistration.setDeviceId(deviceId);

		// Set the location header for the newly created resource
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newUserUri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
		
		responseHeaders.setLocation(newUserUri);
		responseHeaders.add("X-Operation-Status", "SUCCESS");
		responseHeaders.add("X-Operation-Message", deviceId + " Registered");
		
		return new ResponseEntity<>(null,responseHeaders, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET, value = "/v1/registerapp/generateOTP/{deviceId}",  produces= "application/json")
	public ResponseEntity<OTP> generateOTP(@PathVariable("deviceId") String deviceId) {
		
		OTP otp = new OTP();
		otp.setOneTimePassword(OTPGenerator.generateOTP());
		otp.setDeviceId(deviceId);
		
		// Set the location header for the newly created resource
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newUserUri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
		
		responseHeaders.setLocation(newUserUri);
		responseHeaders.add("X-Operation-Status", "SUCCESS");
		responseHeaders.add("X-Operation-Message", "OTP Generated");
		
		return new ResponseEntity<OTP>(null,responseHeaders, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Validate the OTP. This will be called by Bank's SMS Gateway", response= Void.class)
	@RequestMapping(method=RequestMethod.POST, value = "/v1/registerapp/validateOTP", consumes = "application/json")
	public ResponseEntity<?> validateOTP(@RequestBody OTP otp) {
		
		// get the otp and look against the deviceID on appregister collection for the otp
		
		// then pick the phone number and look for a match against users collection
		
		// if found then the validation is successful and then send the status to Google push notification
		// along with phone number and deviceId
		
			
		// Set the location header for the newly created resource
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newUserUri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
		
		responseHeaders.setLocation(newUserUri);
		responseHeaders.add("X-Operation-Status", "SUCCESS");
		responseHeaders.add("X-Operation-Message", "OTP Verified");
		
		return new ResponseEntity<>(null,responseHeaders, HttpStatus.OK);
	}
	
}
