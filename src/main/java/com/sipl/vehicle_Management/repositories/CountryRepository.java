package com.sipl.vehicle_Management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sipl.vehicle_Management.entity.CountryMaster;

@Repository
public interface CountryRepository extends JpaRepository<CountryMaster, Long> {
	@Query("from CountryMaster cm where cm.isDeleted=false  AND cm.isActive=true ORDER BY cm.countryId DESC")
	Page<CountryMaster> findAllpagination(Pageable page);

	//@Query("from CountryMaster cm where cm.isDeleted=false AND cm.isActive=true ORDER BY cm.countryId DESC") 
	@Query("from CountryMaster cm where cm.isActive=true ORDER BY cm.countryId DESC")
	List<CountryMaster> findAllActive();

	//@Query("from CountryMaster cm where cm.countryId=?1 AND cm.isDeleted=false AND cm.isActive=true")
	Optional<CountryMaster> findByCountryId(Long countryId);
	
	@Query("From CountryMaster cm where cm.countryName=?1 and cm.isDeleted=false and cm.isActive=true")
	CountryMaster findByCountryName(String countryName);
}
