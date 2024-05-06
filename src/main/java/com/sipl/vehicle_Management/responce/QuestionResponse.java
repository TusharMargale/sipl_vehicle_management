package com.sipl.vehicle_Management.responce;

import com.sipl.vehicle_Management.entity.Question;

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
public class QuestionResponse {
	private Boolean error;
    private String message;
    private Question question;
}
