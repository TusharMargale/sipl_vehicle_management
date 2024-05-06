package com.sipl.vehicle_Management.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
//import com.sipl.vehicle_Management.dto.UserMasterDto;
import com.sipl.vehicle_Management.entity.UserMaster;
//import com.sipl.vehicle_Management.mappers.UserMapper;
import com.sipl.vehicle_Management.repositories.UserRepository;
//import com.sipl.vehicle_Management.responce.UserResponse;
import com.sipl.vehicle_Management.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
//	@Autowired
//	private UserMapper userMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<UserMaster> getUsers(){
		return userRepository.findAll();
	}
	
	public UserMaster createUser(UserMaster user) {
		user.setId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	

}
