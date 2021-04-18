package com.quizapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.quizapp.dto.Questions;

public class QuestionDaoImpl implements QuestionDao {

	private static final String SELECT_QUESTIONS_BY_LANGUAGE = "select * from questions where question_language=?;";

	public List<Questions> startQuizQuestion(String string) {

		List<Questions> list = new ArrayList<>();
		try {

			Questions questions = null;
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUESTIONS_BY_LANGUAGE);
			preparedStatement.setString(1, string);
			ResultSet res = preparedStatement.executeQuery();
			while (res.next()) {
				String questionLang = res.getString("question_language");
				String question = res.getString("question");
				String answer = res.getString("answer");
				String optionOne = res.getString("option_one");
				String optionTwo = res.getString("option_two");
				String optionThree = res.getString("option_three");
				String optionFour = res.getString("option_four");
				questions = new Questions(questionLang, question, answer, optionOne, optionTwo, optionThree,
						optionFour);
				list.add(questions);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;

	}

	protected Connection getConnection() {

		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_db", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
