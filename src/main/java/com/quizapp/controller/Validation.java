package com.quizapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.quizapp.dto.Questions;

@WebServlet("/validation")
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		List<Questions> list = (List<Questions>) session.getAttribute("questionList");
		System.out.println(list);
		int score = 0;
		for (int i = 0; i < list.size(); i++) {
			String ans = list.get(i).getAnswer();
			if (ans.equals(request.getParameter(ans))) {
				score++;
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");

		response.setContentType("text/html");
		session.setAttribute("score", score);
		session.setAttribute("lang", list.get(0).getQuestionLang());
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
