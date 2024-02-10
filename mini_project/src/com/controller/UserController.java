package com.controller;

import com.model.User;
import com.service.UserService;
import com.view.View;


import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class UserController {
	private List<User> userList = new ArrayList<>();

	public void createUser(String userId, String passwd, String Name) {

		User user = new User(userId, passwd, Name);

		int result = new UserService().insertMember(user);

		if (result > 0) { // 회원 추가 성공
			new View().displaySuccess("회원추가 성공");
		} else { // 회원 추가 실패
			new View().displayFailed("회원추가 실패");
		}

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


	public void selectAllList() {
		// list객체에 회원 전체 목록을 담기
		ArrayList<User> list = new UserService().selectAllList();

		// view쪽에 결과 전달하여 출력
		// list.size() > 0 : 목록을 출력
		// list.size() == 0 : 데이터가 없습니다.
		if (list.isEmpty()) {
			new View().displayNoData(null);
		} else {
			new View().displayList(list);
		}
	}

	public void deleteUser(String userId) {
	}
}
