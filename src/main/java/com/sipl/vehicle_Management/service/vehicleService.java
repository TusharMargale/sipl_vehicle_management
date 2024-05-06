package com.sipl.vehicle_Management.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sipl.vehicle_Management.dto.vehicleDto;
import com.sipl.vehicle_Management.responce.vehicleResponse;

@Service
public interface vehicleService {
	
	vehicleResponse createVehicle(vehicleDto vehicleDto);
	
	vehicleResponse getVehicleById(Long id);
	
	vehicleResponse getAllVehicle();
	
	vehicleResponse updateVehicle(vehicleDto updateVehicleDto);
	
	vehicleResponse deleteVehicle(Long id);
	
	vehicleResponse findAllPagination(Optional<Integer> pageNum, Optional<Integer> pageSize);
}