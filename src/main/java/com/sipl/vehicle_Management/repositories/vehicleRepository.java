package com.sipl.vehicle_Management.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sipl.vehicle_Management.entity.vehicle;

@Repository
public interface vehicleRepository extends JpaRepository<vehicle, Long> {

	@Query("from vehicle v where  v.isActive=true ORDER BY v.id DESC")
	Page<vehicle> findAllPagination(Pageable page);

	@Query("From vehicle v where v.vehicleRegistrationNumber=?1  and v.isActive=true")
	vehicle findByVehicleRegistrationNumber(String vehicleRegistrationNumber);
	
	@Query("from vehicle v where v.isActive=true ORDER BY v.id DESC")
	List<vehicle> findAllVehicle();
	
	//@Query("from vehicle v where v.id=?1 ")
	Optional<vehicle> findVehicleById(Long id);
}
