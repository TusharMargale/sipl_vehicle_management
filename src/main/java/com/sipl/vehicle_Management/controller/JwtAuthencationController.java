package com.sipl.vehicle_Management.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipl.vehicle_Management.request.JwtAuthRequest;
import com.sipl.vehicle_Management.responce.JwtAuthResponse;
import com.sipl.vehicle_Management.security.JwtHelper;

@RestController
@RequestMapping("/auth")

public interface JwtAuthencationController {
	

//	@PostMapping("/login")
//	public JwtAuthResponse createAuthenticationToken(@RequestBody JwtAuthRequest authenticationRequest) throws Exception;

}
