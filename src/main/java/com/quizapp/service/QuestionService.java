package com.quizapp.service;

import java.util.List;

import com.quizapp.dto.Questions;

public interface QuestionService {

	public List<Questions> getQuestions(String string);
}
