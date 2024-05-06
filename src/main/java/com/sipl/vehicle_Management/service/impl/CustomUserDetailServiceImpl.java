package com.sipl.vehicle_Management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sipl.vehicle_Management.entity.UserMaster;
import com.sipl.vehicle_Management.repositories.UserRepository;

@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserMaster user = userRepository.findByEmail(username)
				.orElseThrow(() -> new RuntimeException("User not found !!!"));
		// load user from database

		return user;
	}

}
