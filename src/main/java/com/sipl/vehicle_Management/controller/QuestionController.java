package com.sipl.vehicle_Management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipl.vehicle_Management.dto.QuestionDto;
import com.sipl.vehicle_Management.responce.QuestionResponse;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/v1/questions")
@SecurityRequirement(name = "jwtauth")
public interface QuestionController {
	@PostMapping("/create")
	public ResponseEntity<QuestionResponse> insertQuestion(@RequestBody QuestionDto questionDto);
}
