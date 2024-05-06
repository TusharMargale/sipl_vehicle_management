package com.sipl.vehicle_Management.service;

import org.springframework.stereotype.Service;

import com.sipl.vehicle_Management.dto.AnswerDto;
import com.sipl.vehicle_Management.responce.AnswerResponse;

@Service
public interface AnswerService {
	public AnswerResponse insertAnswer(AnswerDto answerDto);
}
