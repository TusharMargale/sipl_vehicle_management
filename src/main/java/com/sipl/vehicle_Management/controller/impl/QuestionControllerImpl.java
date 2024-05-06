package com.sipl.vehicle_Management.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.sipl.vehicle_Management.controller.QuestionController;
import com.sipl.vehicle_Management.dto.QuestionDto;
import com.sipl.vehicle_Management.responce.QuestionResponse;
import com.sipl.vehicle_Management.service.QuestionService;

@Service
public class QuestionControllerImpl implements QuestionController {
	@Autowired
	private QuestionService questionService;

	@Override
	public ResponseEntity<QuestionResponse> insertQuestion(QuestionDto questionDto) {
		QuestionResponse fetchedResponse = questionService.insertQuestion(questionDto);
		ResponseEntity<QuestionResponse> response = new ResponseEntity<>(fetchedResponse, null, HttpStatus.CREATED);
		return response;
	}

}
