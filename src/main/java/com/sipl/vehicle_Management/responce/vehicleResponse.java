package com.sipl.vehicle_Management.responce;

import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;
import com.sipl.vehicle_Management.dto.vehicleDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class vehicleResponse {
	private vehicleDto vehicleDto;
	private List<vehicleDto> vehicleDtoList;
	private Page<vehicleDto> vehicleDtoPage;
	private HttpStatus status;
	private String message;
	private boolean error;

}
