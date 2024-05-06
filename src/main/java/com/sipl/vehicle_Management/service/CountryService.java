package com.sipl.vehicle_Management.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sipl.vehicle_Management.dto.CountryDto;
import com.sipl.vehicle_Management.responce.CountryResponse;

@Service
public interface CountryService {
	
	public CountryResponse addCountryData(CountryDto countryDto);
	
	public CountryResponse getAllCountryData();
	
	public CountryResponse getCountryById(Long countryId);
	
	public CountryResponse updateCountryData(CountryDto countryDto);
	
	public CountryResponse deleteCountryById(Long countryId);
	
	public CountryResponse findAllPagination(Optional<Integer> pageNum, Optional<Integer> pageSize);
}
