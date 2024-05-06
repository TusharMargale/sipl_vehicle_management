package com.sipl.vehicle_Management.service;

import org.springframework.stereotype.Service;

import com.sipl.vehicle_Management.dto.QuestionDto;
import com.sipl.vehicle_Management.responce.QuestionResponse;
@Service
public interface QuestionService {
	public QuestionResponse insertQuestion(QuestionDto questionDto); 
	
}
