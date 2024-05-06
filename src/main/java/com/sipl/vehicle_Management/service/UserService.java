package com.sipl.vehicle_Management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sipl.vehicle_Management.entity.UserMaster;

//import com.sipl.vehicle_Management.dto.UserMasterDto;
//import com.sipl.vehicle_Management.responce.UserResponse;

@Service
public interface UserService {
	
	public List<UserMaster> getUsers();
	public UserMaster createUser(UserMaster user);
//	UserResponse createUser(UserMasterDto userMasterDto);
//
//	UserResponse getAllUsers();
}
