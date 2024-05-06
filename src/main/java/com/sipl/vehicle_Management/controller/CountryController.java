package com.sipl.vehicle_Management.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sipl.vehicle_Management.dto.CountryDto;
import com.sipl.vehicle_Management.responce.CountryResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/country/")
@SecurityRequirement(name = "jwtauth")
public interface CountryController {

	@GetMapping("/getbycountryid/{countryId}")
	public ResponseEntity<CountryResponse> findById(@PathVariable("countryId") Long countryId);

	@GetMapping("/getallcountry")
	public ResponseEntity<CountryResponse> findAll();

	@PostMapping("/addcountry")
	public ResponseEntity<CountryResponse> addCountry(@RequestBody CountryDto countryDto);

	@DeleteMapping("/deletebycountryid/{countryId}")
	public ResponseEntity<CountryResponse> deleteById(@PathVariable("countryId") Long countryId);

	@PutMapping("/updatecountry")
	public ResponseEntity<CountryResponse> update(@RequestBody CountryDto countryDto);

	@GetMapping("/paginationcountry")
	public ResponseEntity<CountryResponse> getAllPagination(
			@RequestParam(name = "pageNum", defaultValue = "0") Optional<Integer> pageNum,
			@RequestParam(name = "pageSize", defaultValue = "10") Optional<Integer> pageSize);

}
