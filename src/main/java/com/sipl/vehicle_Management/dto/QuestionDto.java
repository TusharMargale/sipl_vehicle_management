package com.sipl.vehicle_Management.dto;

import com.sipl.vehicle_Management.entity.Answer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestionDto {
	private Long questionId;
	private String question;
	private Answer answer;
}
