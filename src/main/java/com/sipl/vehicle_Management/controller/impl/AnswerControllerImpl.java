package com.sipl.vehicle_Management.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.sipl.vehicle_Management.controller.AnswerController;
import com.sipl.vehicle_Management.dto.AnswerDto;
import com.sipl.vehicle_Management.responce.AnswerResponse;
import com.sipl.vehicle_Management.service.AnswerService;

@Component
public class AnswerControllerImpl implements AnswerController {

	@Autowired
	private AnswerService answerService;

	@Override
	public ResponseEntity<AnswerResponse> insertAnswer(AnswerDto answerDto) {
		AnswerResponse fetchedResponse = answerService.insertAnswer(answerDto);
		ResponseEntity<AnswerResponse> response = new ResponseEntity<>(fetchedResponse, null, HttpStatus.CREATED);
		return response;
	}

}
