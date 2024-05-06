package com.sipl.vehicle_Management.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import com.sipl.vehicle_Management.dto.CountryDto;
import com.sipl.vehicle_Management.entity.CountryMaster;



@Mapper(componentModel = "spring")
public interface CountryMapper {
	
//	@Mapping(source="cId", target="countryId")
//	@Mapping(source="cName", target="countryName")
	CountryMaster mapCountryDtoToCountry(CountryDto countryDto);
	
//	@Mapping(source="countryId", target="cId")
//	@Mapping(source="countryName", target="Name")
    CountryDto mapCountryToCountryDto(CountryMaster countryMaster);

    List<CountryDto> mapCountryListToCountryDtoList(List<CountryMaster> countryMasterList);

    default Page<CountryDto> mapCountryEntityPageToCountryDtoPage(Page<CountryMaster> countryMasterPage) {
        return countryMasterPage.map(this::mapCountryToCountryDto);
    }
}
