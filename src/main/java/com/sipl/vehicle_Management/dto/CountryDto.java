package com.sipl.vehicle_Management.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CountryDto {
	private Long countryId;
	//private Long cId;
	private String countryName;
	//private String cName;
	private Boolean isActive;
	private Boolean isDeleted;
	private String createdBy;
	private String modifiedBy;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
}
