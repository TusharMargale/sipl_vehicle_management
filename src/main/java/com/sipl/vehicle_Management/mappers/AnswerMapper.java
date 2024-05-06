package com.sipl.vehicle_Management.mappers;

import org.mapstruct.Mapper;


import com.sipl.vehicle_Management.dto.AnswerDto;
import com.sipl.vehicle_Management.entity.Answer;

@Mapper(componentModel= "spring")
public interface AnswerMapper {
	AnswerDto mapAnswerToAnswerDto(Answer answer);
	Answer mapAnswerDtoToAnswer(AnswerDto answerDto);
}
