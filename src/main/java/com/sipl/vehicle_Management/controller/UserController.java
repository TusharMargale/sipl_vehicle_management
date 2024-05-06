package com.sipl.vehicle_Management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.sipl.vehicle_Management.entity.UserMaster;

//import com.sipl.vehicle_Management.dto.UserMasterDto;
//import com.sipl.vehicle_Management.responce.UserResponse;


@RestController
@RequestMapping("/api/users/")
public interface UserController {
	
	@PostMapping("/createuser")
	public UserMaster createUser(@RequestBody UserMaster user);
	
	@GetMapping("/getuser")
	public List<UserMaster> getUser();
	
//	@PostMapping("/createuser")
//	public ResponseEntity<UserResponse> createUser(@RequestBody UserMasterDto userMasterDto);
//	
//	@GetMapping("/getallusers")
//	public ResponseEntity<UserResponse> getAllUsers();
	
	
}
