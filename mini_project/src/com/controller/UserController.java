package com.controller;

import com.model.User;

public class UserController {
	
	public void creatUser(String userId, String passwd, String name ) {
		User user = new User();
		user.setUserId(userId);
		user.setPasswd(passwd);
		user.setName(name);
	}
	
	public int login(String userId, String passwd) {
		return 0;
	}
	public void deleteUser(String userId) {
	}
}
