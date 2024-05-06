package com.sipl.vehicle_Management.responce;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import com.sipl.vehicle_Management.dto.CountryDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CountryResponse {
	private CountryDto countryDto;
	private List<CountryDto> countryDtos;
	private Page<CountryDto> countryDtoPage;
	private HttpStatus status;
	private String message;
	private boolean error;
}
