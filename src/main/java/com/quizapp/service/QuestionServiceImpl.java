package com.quizapp.service;

import java.util.List;
import java.util.Scanner;

import com.quizapp.dao.QuestionDao;
import com.quizapp.dao.QuestionDaoImpl;
import com.quizapp.dto.Questions;

public class QuestionServiceImpl implements QuestionService {
	QuestionDao questionDao = new QuestionDaoImpl();
	Scanner scanner = new Scanner(System.in);

	public List<Questions> getQuestions(String lanuage) {
		switch (lanuage) {
		case "java":

			return questionDao.startQuizQuestion("java");
		case "HTML":

			return questionDao.startQuizQuestion("HTML");
		case "SQL":

			return questionDao.startQuizQuestion("SQL");
		}
		return null;
	}

}
