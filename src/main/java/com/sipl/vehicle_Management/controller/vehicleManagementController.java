package com.sipl.vehicle_Management.controller;

import java.util.List;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sipl.vehicle_Management.dto.vehicleDto;
import com.sipl.vehicle_Management.responce.vehicleResponse;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/vehicles/")
@SecurityRequirement(name = "jwtauth")
public interface vehicleManagementController {

	
	@PostMapping("/createvehicle")
	public ResponseEntity<vehicleResponse> createVehicle(@RequestBody vehicleDto vehicleDto);
	
	@GetMapping("/getallvehicle")
	public ResponseEntity<vehicleResponse> getAllVehicle();

	@GetMapping("/getvehicle/{id}")
	public ResponseEntity<vehicleResponse> getVehicleById(@PathVariable("id") Long id);
	
	@PutMapping("/updateVehicle")
	public ResponseEntity<vehicleResponse> updateVehicle( @RequestBody vehicleDto vehicleDTO);
	
	@DeleteMapping("/deletevehicle/{id}")
	public ResponseEntity<vehicleResponse> deleteVehicle(@PathVariable("id") Long id);

	@GetMapping("/getallPagination")
	public ResponseEntity<vehicleResponse> getAllPaginationData(
			@RequestParam(name = "pageNum", required = false) Optional<Integer> pageNum,
			@RequestParam(name = "pageSize", required = false) Optional<Integer> pageSize);
	
	//jhskhgslk glsdkghlskdhg  lskghk lklshdlghs lk
}
