package com.sipl.vehicle_Management.responce;

import com.sipl.vehicle_Management.entity.Answer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class AnswerResponse {
	private Boolean error;
    private String message;
    private Answer answer;
}
