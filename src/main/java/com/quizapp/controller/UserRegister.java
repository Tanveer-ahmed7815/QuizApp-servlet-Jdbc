package com.quizapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quizapp.dto.User;
import com.quizapp.service.UserService;
import com.quizapp.service.UserServiceImpl;

@WebServlet("/register")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 User user = new User();
	 UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		if(userService.register(user)) {
			
			dispatcher.forward(request, response);
		}
		else {
			out.println("<h3 style='position:relative;top:340px;left:170px;color:red;'>Username already Exists </h3>");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.include(request, response);
		}
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
