package com.quizapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quizapp.dto.Questions;
import com.quizapp.service.QuestionService;
import com.quizapp.service.QuestionServiceImpl;

@WebServlet("/java")
public class JavaQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * String language = request.getParameter("language");
		 * 
		 * QuestionService qService = new QuestionServiceImpl();
		 * 
		 * List<Questions> question = qService.getQuestions(language);
		 * 
		 * request.setAttribute("questions", question);
		 * 
		 * RequestDispatcher dispatcher = request.getRequestDispatcher("quiz.jsp");
		 * dispatcher.forward(request, response);
		 */

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String language = request.getParameter("language");

		QuestionService qService = new QuestionServiceImpl();

		List<Questions> question = qService.getQuestions(language);

		request.setAttribute("questions", question);

		RequestDispatcher dispatcher = request.getRequestDispatcher("quiz.jsp");
		dispatcher.forward(request, response);
	}

}
