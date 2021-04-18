package com.quizapp.service;

import com.quizapp.dto.User;

public interface UserService {
	public boolean login(User user);
	public boolean register(User user);
}
