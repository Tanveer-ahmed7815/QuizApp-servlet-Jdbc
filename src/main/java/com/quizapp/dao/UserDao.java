package com.quizapp.dao;

import com.quizapp.dto.User;

public interface UserDao {
	public boolean login(User user);
	public boolean register(User user);
}
