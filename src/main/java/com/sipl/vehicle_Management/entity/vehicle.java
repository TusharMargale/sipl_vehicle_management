package com.sipl.vehicle_Management.entity;

import java.time.LocalDateTime;

import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Vehicle_Management")
@Audited
public class vehicle {
	@Id
	private Long id;

	@Column(nullable = false, unique = true, name="vehicle_registration_number")
	private String vehicleRegistrationNumber;

	@Column(nullable = false, name="owner_name")
	private String ownerName;

	@Column(nullable = false, name="brand")
	private String brand;

	@Column(nullable = false, name="registration_expires")
	private LocalDateTime registrationExpires;

	@Column(nullable = false, name="is_active")
	private Boolean isActive;

	@Column(nullable = false, name="created_by")
	private String createdBy;

	@Column(nullable = false, name="creation_time")
	private LocalDateTime creationTime;

	@Column(nullable = false, name="modified_by")
	private String modifiedBy;

	@Column(nullable = false, name="modified_time")
	private LocalDateTime modifiedTime;

}
