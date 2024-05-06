package com.sipl.vehicle_Management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sipl.vehicle_Management.dto.QuestionDto;
import com.sipl.vehicle_Management.entity.Question;
import com.sipl.vehicle_Management.mappers.QuestionMapper;
import com.sipl.vehicle_Management.repositories.QuestionRepository;
import com.sipl.vehicle_Management.responce.QuestionResponse;
import com.sipl.vehicle_Management.service.QuestionService;

@Component
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	QuestionMapper questionMapper;

	@Override
	public QuestionResponse insertQuestion(QuestionDto questionDto) {
		try {
			Question question = questionMapper.mapQuestionDtoToQuestion(questionDto);
			Question savedQuestion = questionRepository.save(question);

			QuestionResponse response = new QuestionResponse(true, "Question Saved !!", savedQuestion);
			return response;
		} catch (Exception e) {
			QuestionResponse response = new QuestionResponse(false, "Error Occured !!", null);
			return response;
		}
	}

}
