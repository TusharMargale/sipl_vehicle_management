package com.sipl.vehicle_Management.controller.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.sipl.vehicle_Management.controller.CountryController;
import com.sipl.vehicle_Management.dto.CountryDto;
import com.sipl.vehicle_Management.responce.CountryResponse;
import com.sipl.vehicle_Management.service.CountryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CountryControllerImpl implements CountryController {

	@Autowired
	private CountryService countryService; 

	@Override
	public ResponseEntity<CountryResponse> addCountry(CountryDto countryDto) {
		log.info("<<START>>  addCountry <<START>> ");
		ResponseEntity<CountryResponse> responseEntity = new ResponseEntity<>(countryService.addCountryData(countryDto),
				HttpStatus.OK);
		log.info("<<END>> addCountry <<END>>");
		return responseEntity;
	}

	@Override
	public ResponseEntity<CountryResponse> findAll() {
		log.info("<<START>>  getAllCountry <<START>> ");
		ResponseEntity<CountryResponse> responseEntity = new ResponseEntity<>(countryService.getAllCountryData(),
				HttpStatus.OK);
		log.info("<<END>> getAllCountry <<END>>");
		return responseEntity;
	}

	@Override
	public ResponseEntity<CountryResponse> update(CountryDto countryDto) {
		log.info("<<START>>  updateCountry <<START>> ");
		ResponseEntity<CountryResponse> responseEntity = new ResponseEntity<>(countryService.updateCountryData(countryDto),
				HttpStatus.OK);
		log.info("<<END>> updateCountry <<END>>");
		return responseEntity;
	}

	@Override
	public ResponseEntity<CountryResponse> findById(Long id) {
		log.info("<<START>>  getCountryById <<START>> ");
		ResponseEntity<CountryResponse> responseEntity = new ResponseEntity<>(countryService.getCountryById(id),
				HttpStatus.OK);
		log.info("<<END>> getCountryById <<END>>");
		return responseEntity;
	}

	@Override
	public ResponseEntity<CountryResponse> deleteById(@PathVariable("countryId")Long countryId) {
		log.info("<<START>>  deleteCountry <<START>> ");
		ResponseEntity<CountryResponse> responseEntity = new ResponseEntity<>(countryService.deleteCountryById(countryId),
				HttpStatus.OK);
		log.info("<<END>> deleteCountry <<END>>");
		return responseEntity;
	}

	@Override
	public ResponseEntity<CountryResponse> getAllPagination(Optional<Integer> pageNum, Optional<Integer> pageSize) {
		log.info("<<START>>  getAllPagination <<START>> ");
		ResponseEntity<CountryResponse> responseEntity = new ResponseEntity<>(
				countryService.findAllPagination(pageNum, pageSize), HttpStatus.OK);
		log.info("<<END>> getAllPagination <<END>>");
		return responseEntity;
	}

}
