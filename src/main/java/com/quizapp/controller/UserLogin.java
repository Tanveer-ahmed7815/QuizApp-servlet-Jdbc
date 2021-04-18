package com.quizapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.quizapp.dto.User;
import com.quizapp.service.UserService;
import com.quizapp.service.UserServiceImpl;

@WebServlet("/login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	User user = new User();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));

		HttpSession httpSession = request.getSession();

		UserService userService = new UserServiceImpl();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
		if (userService.login(user)) {
			httpSession.setAttribute("name", request.getParameter("userName"));
			dispatcher.forward(request, response);
		} else {

			out.println("<h3>Invalid Username or Password </h3>");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.include(request, response);
		}
	}

}
