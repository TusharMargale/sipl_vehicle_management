package com.sipl.vehicle_Management.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.sipl.vehicle_Management.dto.CountryDto;
import com.sipl.vehicle_Management.entity.CountryMaster;
import com.sipl.vehicle_Management.mappers.CountryMapper;
import com.sipl.vehicle_Management.repositories.CountryRepository;
import com.sipl.vehicle_Management.responce.CountryResponse;
import com.sipl.vehicle_Management.service.CountryService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CountryMapper countryMapper;

	// add country data.
	@Override
	public CountryResponse addCountryData(CountryDto countryDto) {

		try {
			CountryMaster countryName = countryRepository.findByCountryName(countryDto.getCountryName());
			if (countryName == null) {
				log.info("Create Country.");
				CountryMaster country = countryMapper.mapCountryDtoToCountry(countryDto);
				log.info("country mapper called.");

				LocalDateTime currentTime = LocalDateTime.now();
				country.setCreatedDate(currentTime);
				country.setModifiedDate(currentTime);
				country.setIsDeleted(false);
				country.setIsActive(true);
				//CountryMaster savedCountry = countryRepository.save(country);
				country = countryRepository.save(country);
				log.info(" Country repository");
				CountryDto savedCountryDto = countryMapper.mapCountryToCountryDto(country);
				log.info("Country saved successfully");
				CountryResponse response = new CountryResponse(savedCountryDto, null, null, HttpStatus.CREATED,
						"Country saved successfully", false);
				return response;
			} else {
				CountryResponse response = new CountryResponse(null, null, null, HttpStatus.NOT_FOUND,
						"Country Name" + countryDto.getCountryName()+"Already Exist", true);
				return response;
			}
		} catch (final org.hibernate.exception.JDBCConnectionException e) {
			log.error("Vehicle addData JDBCConnectionException: ", e);
		} catch (Exception e) {
			log.error("An error occurred while saving CountryMaster", e);
		}
		return new CountryResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR,
				"An error occurred while saving CountryMaster", false);

	}

	@Override
	public CountryResponse getCountryById(Long countryId) {
		try {
			log.info("Finding CountryMaster with ID: {}", countryId);
			Optional<CountryMaster> countryOptional = countryRepository.findByCountryId(countryId);
			if (countryOptional.isPresent()) {
				CountryMaster entity = countryOptional.get();
				CountryDto countryDto = countryMapper.mapCountryToCountryDto(entity);
				log.info("CountryMaster found with ID: {}", countryId);
				return new CountryResponse(countryDto, null, null, HttpStatus.FOUND, "CountryMaster found", true);
			} else {
				log.warn("CountryMaster not found with ID: {}", countryId);
				return new CountryResponse(null, null, null, HttpStatus.NOT_FOUND, "CountryMaster not found", false);
			}
		} catch (final org.hibernate.exception.JDBCConnectionException e) {
			log.error("Vehicle getAll JDBCConnectionException:", e);
		} catch (Exception e) {
			log.error("An error occurred while finding CountryMaster with ID: {}", countryId, e);
		}
		return new CountryResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR,
				"An error occurred while finding CountryMaster", false);
	}

	@Override
	public CountryResponse getAllCountryData() {
		try {
			log.info("Finding all CountryMaster");
			List<CountryMaster> countryMaster = (List<CountryMaster>) countryRepository.findAllActive();
			if (countryMaster.isEmpty()) {
				log.warn("No CountryMaster found in the database");
				return new CountryResponse(null, null, null, HttpStatus.NOT_FOUND,
						"No CountryMaster found in the database", false);
			} else {
				List<CountryDto> countryDtos = countryMaster.stream().map(countryMapper::mapCountryToCountryDto)
						.collect(Collectors.toList());
				log.info("CountryMaster retrieved successfully");
				return new CountryResponse(null, countryDtos, null, HttpStatus.OK,
						"CountryMaster retrieved successfully", true);
			}
		} catch (final org.hibernate.exception.JDBCConnectionException e) {
			log.error("Vehicle getAll JDBCConnectionException: ", e);
		} catch (Exception e) {
			log.error("An error occurred while retrieving CountryMaster", e);
		}
		return new CountryResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR,
				"An error occurred while retrieving CountryMaster", false);
	}

	@Override
	public CountryResponse updateCountryData(CountryDto countryDto) {
		try {
			log.info("Updating CountryMaster with ID: {}", countryDto.getCountryId());
			Optional<CountryMaster> optionalEntity = countryRepository.findByCountryId(countryDto.getCountryId());
			if (optionalEntity.isPresent()) {
				CountryMaster existingEntity = countryMapper.mapCountryDtoToCountry(countryDto);
				existingEntity.setIsDeleted(false);
				existingEntity.setIsActive(true);
				// existingEntity.setCountryId(optionalEntity.get().getCountryId());
				//CountryMaster updateCountryMaster = countryRepository.save(existingEntity);
				existingEntity = countryRepository.save(existingEntity);
				CountryDto updatedCountryDto = countryMapper.mapCountryToCountryDto(existingEntity);
				log.info("CountryMaster updated successfully with ID: {}", countryDto.getCountryId());
				return new CountryResponse(updatedCountryDto, null, null, HttpStatus.OK, "CountryMaster updated successfully",
						false);
			} else {
				log.warn("CountryMaster not found with ID: {}", countryDto.getCountryId());
				return new CountryResponse(null, null, null, HttpStatus.NOT_FOUND, "CountryMaster not found", true);
			}
		} catch (final org.hibernate.exception.JDBCConnectionException e) {
			log.error("Vehicle getAll JDBCConnectionException: ", e);
		} catch (Exception e) {
			log.error("An error occurred while updating CountryMaster", e);

		}
		return new CountryResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR,
				"An error occurred while updating CountryMaster", true);
	}

	@Override
	public CountryResponse deleteCountryById(Long countryId) {

		try {
			log.info("<<start>>In CountryMaster deleteById method<<start>>");
			log.info("Deleting CountryMaster with ID: " + countryId);
			final Optional<CountryMaster> countryOptional = countryRepository.findByCountryId(countryId);
			log.info("CountryMaster deleteCountryById response: " + countryOptional);
			if (countryOptional.isPresent()) {
				CountryMaster countryIdFromDb = countryOptional.get();
				countryIdFromDb.setIsDeleted(true);
				countryIdFromDb.setIsActive(false);
				countryRepository.save(countryIdFromDb);
				log.info("Updated CountryMaster with ID: " + countryId + ", active set to false");
				final CountryDto countryDtoToSend = countryMapper.mapCountryToCountryDto(countryIdFromDb);
				log.info("Sending updated countryDto response: " + countryDtoToSend);
				return new CountryResponse(countryDtoToSend, null, null, HttpStatus.OK,
						"CountryMaster deleted successfully", true);
			} else {
				return new CountryResponse(null, null, null, HttpStatus.NOT_FOUND, "CountryMaster not found", false);
			}
		} catch (final org.hibernate.exception.JDBCConnectionException e) {
			log.error("Vehicle deleteById JDBCConnectionException:", e);
		} catch (Exception e) {
			log.error("An error occurred while deleting CountryMaster", e);
		}
		return new CountryResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", true);
	}

	@Override
	public CountryResponse findAllPagination(Optional<Integer> pageNum, Optional<Integer> pageSize) {
		try {
			log.info("Retrieving CountryMaster with pagination");
			int page = pageNum.orElse(0);
			int size = pageSize.orElse(10);
			Pageable pageable = PageRequest.of(page, size);
			Page<CountryMaster> countryMaster = countryRepository.findAllpagination(pageable);
			if (countryMaster.isEmpty()) {
				log.warn("No CountryMaster found in the database for the given page");
				return new CountryResponse(null, null, null, HttpStatus.NOT_FOUND,
						"No CountryMaster found in the database for the given page", false);
			} else {
				List<CountryDto> dtos = countryMaster.getContent().stream().map(countryMapper::mapCountryToCountryDto)
						.collect(Collectors.toList());
				log.info("CountryMaster retrieved successfully with pagination");
				return new CountryResponse(null, dtos, null, HttpStatus.OK,
						"CountryMaster retrieved successfully with pagination", true);
			}
		} catch (Exception e) {
			log.error("An error occurred while retrieving CountryMaster with pagination", e);
		}
		return new CountryResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR,
				"An error occurred while retrieving CountryMaster with pagination", false);
	}
}
