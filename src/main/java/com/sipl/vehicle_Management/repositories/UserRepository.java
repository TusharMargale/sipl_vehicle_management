package com.sipl.vehicle_Management.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sipl.vehicle_Management.entity.UserMaster;
import com.sipl.vehicle_Management.entity.vehicle;

@Repository
public interface UserRepository extends JpaRepository<UserMaster, String>{
	
	//@Query("From UserMaster u where u.email = :email")
	Optional <UserMaster> findByEmail(String email);
	
//	@Query("From UserMaster u where u.username = :username")
//		Optional <UserMaster> findByUsername(String username);
	
	
//	//@Query("From UserMaster ")
//	List<UserMaster> findAllUser();
}
		