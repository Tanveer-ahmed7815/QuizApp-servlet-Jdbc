package com.quizapp.service;

import com.quizapp.dao.ResultDao;
import com.quizapp.dao.ResultDaoImpl;
import com.quizapp.dto.Results;

public class ResultServiceImpl implements ResultService {

	public void addResult(Results results) {
		ResultDao resultDao = new ResultDaoImpl();
		resultDao.setResult(results);
		
	}

}
