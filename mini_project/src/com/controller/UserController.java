package com.controller;

import com.model.User;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class UserController {
	private List<User> userList = new ArrayList<>();
	
	public void creatUser(String userId, String passwd, String name ) {
		User user = new User();
		user.setUserId(userId);
		user.setPasswd(passwd);
		user.setName(name);
		userList.add(user);
	}


	//1 : 로그인 성공, 2 : 아이디 없음, 3 : 비밀번호 다름
	public int login(String userId, String passwd) {
		for(User user:userList){
			if(user.getUserId().equals(userId) && user.getPasswd().equals(passwd)){
				return 1;
			}
			else if(user.getUserId().equals(userId)){
				return 3;
			}
			else return 2;
		}
		return 2;
	}
	public void deleteUser(String userId) {
	}
}
