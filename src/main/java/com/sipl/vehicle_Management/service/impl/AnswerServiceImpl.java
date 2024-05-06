package com.sipl.vehicle_Management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sipl.vehicle_Management.dto.AnswerDto;
import com.sipl.vehicle_Management.entity.Answer;
import com.sipl.vehicle_Management.mappers.AnswerMapper;
import com.sipl.vehicle_Management.repositories.AnswerRepository;
import com.sipl.vehicle_Management.responce.AnswerResponse;
import com.sipl.vehicle_Management.service.AnswerService;

@Component
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	AnswerRepository answerRepository;
	@Autowired
	AnswerMapper answerMapper;

	@Override
	public AnswerResponse insertAnswer(AnswerDto answerDto) {
		try {
			Answer answer = answerMapper.mapAnswerDtoToAnswer(answerDto);
			Answer savedAnswer = answerRepository.save(answer);

			AnswerResponse response = new AnswerResponse(true, "Answer Saved !!", savedAnswer);
			return response;
		} catch (Exception e) {
			AnswerResponse response = new AnswerResponse(false, "Error Occured !!", null);
			return response;
		}
	}

}
