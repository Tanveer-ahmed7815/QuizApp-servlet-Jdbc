package com.quizapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.quizapp.dto.Results;

public class ResultDaoImpl implements ResultDao {

	private static final String INSERT_SCORE_INTO_RESULT = "insert into result(user_name,question_language,score) values (?,?,?);";

	public void setResult(Results results) {

		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SCORE_INTO_RESULT);
			preparedStatement.setString(1, results.getUserName());
			preparedStatement.setString(2, results.getQuestionLang());
			preparedStatement.setInt(3, results.getScore());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private Connection getConnection() {
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
