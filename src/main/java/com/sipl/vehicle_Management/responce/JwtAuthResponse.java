package com.sipl.vehicle_Management.responce;

import java.util.Optional;

import com.sipl.vehicle_Management.entity.UserMaster;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JwtAuthResponse {

	private String Token;
	private String username;

}
