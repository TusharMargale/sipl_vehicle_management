package com.sipl.vehicle_Management.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.sipl.vehicle_Management.dto.vehicleDto;
import com.sipl.vehicle_Management.entity.vehicle;
import com.sipl.vehicle_Management.mappers.vehicleMapper;
import com.sipl.vehicle_Management.repositories.vehicleRepository;
import com.sipl.vehicle_Management.responce.vehicleResponse;
import com.sipl.vehicle_Management.service.vehicleService;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Component
@Slf4j
public class vehicleServiceImpl implements vehicleService {
	@Autowired
	private vehicleRepository vehicleRepository;
	@Autowired
	private vehicleMapper vehicleMapper;

	// insert a new vehicle Details
	@Override
	public vehicleResponse createVehicle(vehicleDto vehicleDto) {
		try {
			vehicle vehicleRegistrationNumber = vehicleRepository
					.findByVehicleRegistrationNumber(vehicleDto.getVehicleRegistrationNumber());
			if (vehicleRegistrationNumber == null) {
				log.info("Creating vehicle. ");
				vehicle vehicle = vehicleMapper.mapVehicleDtoTOVehicle(vehicleDto);
				LocalDateTime currentTime = LocalDateTime.now();
				vehicle.setCreationTime(currentTime);
				vehicle.setModifiedTime(currentTime);
				vehicle.setRegistrationExpires(LocalDateTime.now().plusYears(3));

				vehicle savedVehicle = vehicleRepository.save(vehicle);
				vehicleDto savedVehicleDto = vehicleMapper.mapVehicleToVehicleDto(savedVehicle);
				log.info("Vehicle saved successfully");

				vehicleResponse response = new vehicleResponse(savedVehicleDto, null, null, HttpStatus.CREATED,
						"Vehicle Created. ", false);
				return response;
			} else {
				vehicleResponse response = new vehicleResponse(null, null, null, HttpStatus.NOT_FOUND,
						"Vehicle Already Exist !! ", true);
				return response;
			}
		} catch (final org.hibernate.exception.JDBCConnectionException e) {
			log.error("Vehicle addData JDBCConnectionException: ", e);
		} catch (Exception e) {
			log.error("Vehicle addData Exception: ", e);
		}
		return new vehicleResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, "Vehicle Created. ", false);
	}

	// get vehicle by ID.
	@Override
	public vehicleResponse getVehicleById(Long id) {
		try {
			log.info("Find vehicle with ID: {}", id);
			final Optional<vehicle> vehicles = vehicleRepository.findVehicleById(id);
			if (vehicles.isPresent()) {
				vehicle vehicle = vehicles.get();
				vehicleDto vehicleDto = vehicleMapper.mapVehicleToVehicleDto(vehicle);
				//vehicleDto.setBrand(vehicle.getBrand());

				log.info("Vehicle found with ID: {}", id);
				vehicleResponse response = new vehicleResponse(vehicleDto, null, null, HttpStatus.FOUND,
						"Vehicle Found.", false);

				return response;
			} else {
				log.warn("Vehicle not found with ID: {}", id);
				return new vehicleResponse(null, null, null, HttpStatus.NOT_FOUND, "Vehicle not found.", false);
			}
		} catch (final org.hibernate.exception.JDBCConnectionException e) {
			log.error("Vehicle getAll JDBCConnectionException:", e);
		} catch (Exception e) {
			log.error("An error occurred while finding vehicle with ID: {}", id, e);
		}
		return new vehicleResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR,
				"An error occurred while Finding vehicle.", false);
	}

	// get all vehicles.
	@Override
	public vehicleResponse getAllVehicle() {
		try {
			log.info("findtAllVehicle() method called.");
			final List<vehicle> allvehicles = (List<vehicle>) vehicleRepository.findAllVehicle();
			if (allvehicles.isEmpty()) {
				log.info("if condition is cleared. ");

				return new vehicleResponse(null, null, null, HttpStatus.NOT_FOUND, "Vehicle not found. ", false);
			} else {
				List<vehicleDto> vehicleDtos = allvehicles.stream().map(vehicleMapper::mapVehicleToVehicleDto)
						.collect(Collectors.toList());
				return new vehicleResponse(null, vehicleDtos, null, HttpStatus.OK, "Vehicle found. ", false);
			}
		} catch (final org.hibernate.exception.JDBCConnectionException e) {
			log.error("Vehicle getAll JDBCConnectionException: ", e);

		} catch (Exception e) {
			log.error("Exception in create vehicle ", e);
		}
		return new vehicleResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", false);
	}

		//Update Vehicle 
	
	@Override
	public vehicleResponse updateVehicle(vehicleDto vehicleDto) {
		try {
			log.info("Updating project with ID: {}");
			Optional<vehicle> existingVehicle = vehicleRepository.findVehicleById(vehicleDto.getId());
			if (existingVehicle.isPresent()) {
				vehicle updatedVehicle = vehicleMapper.mapVehicleDtoTOVehicle(vehicleDto);
				updatedVehicle.setIsActive(true);

				 updatedVehicle = vehicleRepository.save(updatedVehicle);
				vehicleDto updatedVehicleDto = vehicleMapper.mapVehicleToVehicleDto(updatedVehicle);
				log.info("Vehicle updated successfully with ID: {}", vehicleDto);

				vehicleResponse response = new vehicleResponse(updatedVehicleDto, null, null, HttpStatus.OK,
						"Vehicle update successfully. ", false);
				return response;
			} else {
				log.warn("vehicle not found with id {}");
				return new vehicleResponse(null, null, null, HttpStatus.NOT_FOUND, "Vehicle not found. ", true);
			}
		} catch (final org.hibernate.exception.JDBCConnectionException e) {
			log.error("Vehicle getAll JDBCConnectionException: ", e);
		} catch (Exception e) {
			log.error("An error occurred while updating vehicle with ID: {}", e);
		}
		return new vehicleResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR,
				"An error occurred while updating vehicle. ", true);
	}
	
	//delete vehicle (isActive = false)

	@Override
	public vehicleResponse deleteVehicle(Long id) {
		try {
			log.info("Delete vehicle  with ID: {id}", id);
			final Optional<vehicle> idFetchedFromDb = vehicleRepository.findVehicleById(id);
			if (idFetchedFromDb.isPresent()) {
				vehicle vehicleFromDb = idFetchedFromDb.get();
				vehicleFromDb.setIsActive(false);
				vehicleRepository.save(vehicleFromDb);
				log.info("Updated vehicle with id: " + id + ", active set to false");
				final vehicleDto vehicleDtoToSend = vehicleMapper.mapVehicleToVehicleDto(vehicleFromDb);
				log.info("Sending updated VehicleIdFetchedFromDb response: " + vehicleDtoToSend);
				return new vehicleResponse(vehicleDtoToSend, null, null, HttpStatus.OK,
						"Vehicle with ID " + id + " Deleted successfully.", true);
			} else {
				return new vehicleResponse(null, null, null, HttpStatus.NOT_FOUND, "Vehicle Doesn't Exists", false);
			}
		} catch (final org.hibernate.exception.JDBCConnectionException e) {
			log.error("Vehicle deleteById JDBCConnectionException:", e);
		} catch (Exception e) {
			log.error("An error occurred while deleting Vehicle with ID: {}", id, e);

		}
		return new vehicleResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR,
				"An error occurred while deleting vehicle. ", false);
	}

	//page 
	
	@Override
	public vehicleResponse findAllPagination(Optional<Integer> pageNum, Optional<Integer> pageSize) {
		log.info("<<start>> getAllVehiclePagination <<start>>");
		try {
			final Page<vehicle> vehicleList = vehicleRepository
					.findAllPagination(PageRequest.of(pageNum.orElse(0), pageSize.orElse(3)));
			log.info("vehicleList" + vehicleList);
			if (vehicleList != null && !vehicleList.isEmpty()) {
				final Page<vehicleDto> vehicleDto = vehicleMapper.vehicleListToVehicleDtoList(vehicleList);
				return new vehicleResponse(null, null, vehicleDto, HttpStatus.FOUND, "Vehicle List Found", false);
			} else {
				return new vehicleResponse(null, null, null, HttpStatus.NOT_FOUND, "Vehicle List Not Found", true);
			}
		} catch (final org.hibernate.exception.JDBCConnectionException e) {
			log.error("database connectivity error", e);
		} catch (Exception e) {
			log.error("Exception occurs in getAllPagination method", e);
		}
		return new vehicleResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", true);
	}

}
