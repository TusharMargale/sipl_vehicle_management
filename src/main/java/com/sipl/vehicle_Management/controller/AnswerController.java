package com.sipl.vehicle_Management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipl.vehicle_Management.dto.AnswerDto;
import com.sipl.vehicle_Management.responce.AnswerResponse;

@RestController
@RequestMapping("/api/v1/answers")
public interface AnswerController {
	@PostMapping("/create")
	public ResponseEntity<AnswerResponse> insertAnswer(@RequestBody AnswerDto answerDto);

}
