package com.sipl.vehicle_Management.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import com.sipl.vehicle_Management.dto.vehicleDto;
import com.sipl.vehicle_Management.entity.vehicle;

@Mapper(componentModel = "spring")
public interface vehicleMapper {
	
	
	@Mapping(source="brandName", target="brand")
	vehicle mapVehicleDtoTOVehicle(vehicleDto vehicleDto);
	
	@Mapping(source="brand", target="brandName")
	vehicleDto mapVehicleToVehicleDto(vehicle vehicle);

	List<vehicleDto> maplistVehicleTolistVehicleDto(List<vehicle> vehicleList);

	default Page<vehicleDto> vehicleListToVehicleDtoList(Page<vehicle> vehicle) {
		return vehicle.map(this::mapVehicleToVehicleDto);
	}
}
