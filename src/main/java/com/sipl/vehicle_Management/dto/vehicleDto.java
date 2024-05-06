package com.sipl.vehicle_Management.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class vehicleDto {

	private long id;

	private String vehicleRegistrationNumber;
	//private String registrationNumber;

	private String ownerName;

	//private String brand;
	private String brandName;

	private LocalDateTime registrationExpires;

	private Boolean isActive;

	private String createdBy;

	private LocalDateTime creationTime;

	private String modifiedBy;

	private LocalDateTime modifiedTime;

}
