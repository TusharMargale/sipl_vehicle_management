package com.sipl.vehicle_Management.mappers;

import org.mapstruct.Mapper;

import com.sipl.vehicle_Management.dto.QuestionDto;
import com.sipl.vehicle_Management.entity.Question;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionDto mapQuestionToQuestionDto(Question question);

    Question mapQuestionDtoToQuestion(QuestionDto questionDto);
}
