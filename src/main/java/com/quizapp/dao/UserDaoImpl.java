package com.quizapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.quizapp.dto.User;

public class UserDaoImpl implements UserDao {

	public boolean login(User user) {

		boolean bool = fetchUser(user);
		if (bool == false) {

			return true;
		}

		return false;

	}

	private static final String INSERT_USER_CREDENTIALS = "insert into user(user_name,password) values (?,?);";

	private static final String SELECT_USER_BY_NAME_AND_PASSWORD = "select * from user "
			+ " where user_name=? and password=?";

	public boolean register(User user) {

		boolean isExistingUser = fetchUser(user);

		if (isExistingUser == true) {
			try {
				Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_CREDENTIALS);
				preparedStatement.setString(1, user.getUserName());
				preparedStatement.setString(2, user.getPassword());

				int result = preparedStatement.executeUpdate();
				if (result == 1) {
					return true;
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return false;

	}

	private boolean fetchUser(User user) {

		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_NAME_AND_PASSWORD);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			ResultSet res = preparedStatement.executeQuery();
			if (!res.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
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
