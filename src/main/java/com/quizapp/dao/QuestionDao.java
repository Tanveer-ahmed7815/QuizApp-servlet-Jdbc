package com.quizapp.dao;

import java.util.List;

import com.quizapp.dto.Questions;

public interface QuestionDao {

	public List<Questions> startQuizQuestion(String string);
	
}
