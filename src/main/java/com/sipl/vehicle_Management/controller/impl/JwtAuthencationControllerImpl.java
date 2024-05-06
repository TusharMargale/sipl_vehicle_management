package com.sipl.vehicle_Management.controller.impl;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sipl.vehicle_Management.controller.JwtAuthencationController;
import com.sipl.vehicle_Management.entity.UserMaster;
import com.sipl.vehicle_Management.repositories.UserRepository;
import com.sipl.vehicle_Management.request.JwtAuthRequest;
import com.sipl.vehicle_Management.responce.JwtAuthResponse;
import com.sipl.vehicle_Management.security.JwtHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequestMapping("/auth")
public class JwtAuthencationControllerImpl implements JwtAuthencationController {
    
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtHelper helper;
	
	//private Logger logger = LoggerFactory.getLogger(JwtAuthencationController.class);
	
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> login(@RequestBody JwtAuthRequest request) {

		this.doAuthenticate(request.getEmail(), request.getPassword());

		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
		String token = this.helper.generateToken(userDetails);

		JwtAuthResponse response = JwtAuthResponse.builder().Token(token).username(userDetails.getUsername()).build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private void doAuthenticate(String email, String password) {

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
		try {
			authenticationManager.authenticate(authentication);

		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(" Invalid Username or Password  !!");
		}

	}

	@ExceptionHandler(BadCredentialsException.class)
	public String exceptionHandler() {
		return "Credentials Invalid !!";
	}

}
