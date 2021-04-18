package com.quizapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questions {

	private String questionLang;
	private String question;
	private String answer;
	private String optionOne;
	private String optionTwo;
	private String optionThree;
	private String optionFour;

}
