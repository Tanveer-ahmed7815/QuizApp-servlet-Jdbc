package com.quizapp.service;

import com.quizapp.dao.UserDao;
import com.quizapp.dao.UserDaoImpl;
import com.quizapp.dto.User;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	public boolean login(User user) {
		if(userDao.login(user)) {
			return true;
		}
		
		return false;
	}

	public boolean register(User user) {
		if(userDao.register(user)) {
			return true;
		}
		return false;
	}

}
