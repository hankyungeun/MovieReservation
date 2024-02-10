package com.controller;

import com.model.User;
import com.service.UserService;
import com.view.View;


import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class UserController {
	private List<User> userList = new ArrayList<>();

	// 회원가입
	public void createUser(String userId, String passwd, String Name) {

		User user = new User(userId, passwd, Name);

		int result = new UserService().insertUser(user);

		if (result > 0) { // 회원 추가 성공
			new View().displaySuccess("회원추가 성공");
		} else { // 회원 추가 실패
			new View().displayFailed("회원추가 실패");
		}

	}


	// 로그인
	public boolean login(String userId, String passwd) {

		User user = new UserService().login(userId, passwd);

		if (user == null) {
			new View().displayNoData("로그인 정보가 없습니다");
			return false;
		} else {
			new View().displayUser(user);
			return true;
		}
	}

	public void deleteUser(String userId) {
	}
}
