package com.sipl.vehicle_Management.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sipl.vehicle_Management.controller.UserController;
import com.sipl.vehicle_Management.entity.UserMaster;
//import com.sipl.vehicle_Management.dto.UserMasterDto;
//import com.sipl.vehicle_Management.responce.UserResponse;
import com.sipl.vehicle_Management.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserControllerImpl implements UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/createuser")
	public UserMaster createUser(@RequestBody UserMaster user) {
		return userService.createUser(user);
	}

	@GetMapping("/getuser")
	public List<UserMaster> getUser(){
		System.out.println("Getting users..");
		return userService.getUsers();
	}

//	@Override
//	public ResponseEntity<UserResponse> createUser(UserMasterDto userMasterDto) {
//		log.info("user Create");
//		ResponseEntity<UserResponse> responseEntity = new ResponseEntity<>(userService.createUser(userMasterDto),HttpStatus.OK);
//		log.info("user Created. ");
//		return responseEntity;
//		
//	}
//
//	@Override
//	public ResponseEntity<UserResponse> getAllUsers() {
//		log.info("user Called");
//		ResponseEntity<UserResponse> responseEntity = new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
//		log.info("GET ALL USERS ");
//		return responseEntity;
//	}

}
