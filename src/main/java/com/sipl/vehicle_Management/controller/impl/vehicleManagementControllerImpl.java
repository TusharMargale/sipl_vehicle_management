package com.sipl.vehicle_Management.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipl.vehicle_Management.controller.vehicleManagementController;
import com.sipl.vehicle_Management.dto.vehicleDto;
import com.sipl.vehicle_Management.responce.vehicleResponse;
import com.sipl.vehicle_Management.service.vehicleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class vehicleManagementControllerImpl implements vehicleManagementController {

	@Autowired
	private vehicleService vehicleService;

	@Override
	public ResponseEntity<vehicleResponse> createVehicle(vehicleDto vehicleDto) {
		log.info("<<START>> Vehicle create <<START>>");
		ResponseEntity<vehicleResponse> responseEntity = new ResponseEntity<>(vehicleService.createVehicle(vehicleDto),
				HttpStatus.OK);
		log.info("<<END>> Vehicle create <<END>>");
		return responseEntity;
	}

	@Override
	public ResponseEntity<vehicleResponse> getAllVehicle() {
		log.info("<<START>> Vehicle called <<START>>");
		ResponseEntity<vehicleResponse> responseEntity = new ResponseEntity<>(vehicleService.getAllVehicle(),
				HttpStatus.OK);
		log.info("<<END>> Vehicle <<END>>");
		return responseEntity;
	}

	@Override
	public ResponseEntity<vehicleResponse> getVehicleById(Long id) {
		log.info("<<START>> vehicle getVehicleById called <<START>>");
		ResponseEntity<vehicleResponse> responseEntity = new ResponseEntity<>(vehicleService.getVehicleById(id),
				HttpStatus.OK);
		log.info("<<END>> project getVehicleById <<END>>");
		return responseEntity;
	}

	@Override
	public ResponseEntity<vehicleResponse> updateVehicle(vehicleDto vehicleDTO) {
		log.info("<<START>> vehicle updateVehicle called <<START>>");
		ResponseEntity<vehicleResponse> responseEntity = new ResponseEntity<>(vehicleService.updateVehicle(vehicleDTO),
				HttpStatus.OK);
		log.info("<<END>> vehicle updateVehicle <<END>>");
		return responseEntity;
	}

	@Override
	public ResponseEntity<vehicleResponse> deleteVehicle(@PathVariable("id") Long id) {
		log.info("<<START>> project Delete called <<START>>");
		ResponseEntity<vehicleResponse> responseEntity = new ResponseEntity<>(
				vehicleService.deleteVehicle(id), HttpStatus.OK);
		log.info("<<END>> project Delete <<END>>");
		return responseEntity;
	}

	@Override
	public ResponseEntity<vehicleResponse> getAllPaginationData(Optional<Integer> pageNum, Optional<Integer> pageSize) {
		log.info("<<START>> getAllProjectPagination <<START>>");
		ResponseEntity<vehicleResponse> responseEntity = new ResponseEntity<>(
				vehicleService.findAllPagination(pageNum, pageSize), HttpStatus.OK);
		log.info("<<END>> getAllProjectPagination <<END>>");
		return responseEntity;
	}


}
