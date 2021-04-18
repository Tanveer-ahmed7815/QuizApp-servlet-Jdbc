package com.quizapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.quizapp.dto.Results;
import com.quizapp.service.ResultService;
import com.quizapp.service.ResultServiceImpl;

@WebServlet("/result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ResultService resultService = new ResultServiceImpl();
		HttpSession session = request.getSession(false);

		String userName = (String) session.getAttribute("name");
		String questionLanguage = (String) session.getAttribute("lang");
		int score = (int) session.getAttribute("score");
		Results results = new Results(userName, questionLanguage, score);
		resultService.addResult(results);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
