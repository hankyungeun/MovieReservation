package com.view;

import java.util.Scanner;

import com.controller.MovieController;
import com.controller.UserController;

public class view {
	Scanner sc = new Scanner(System.in);
	UserController userController = new UserController();
	MovieController movieController = new MovieController();
	
	public void mainMenu() {
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.print("입력");
		int select = sc.nextInt();
		
	}
	
	public void registerView() {
		
	}
	
	public void loginView() {
		while(true) {
			
			System.out.print("아이디 : ");
			String id = sc.next();
			System.out.print("비밀번호 : ");
			String passwd = sc.next();
			
			if(userController.login(id,passwd) == 1) {
				userMenu();
				return;
			}
			else if(userController.login(id,passwd) == 2) {
				System.out.println("없는 아이디입니다.");
			}
			else if(userController.login(id,passwd) == 3) {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
			
		}
		
	}
	
	public void userMenu() {
		System.out.println("영화 예매하기");
		
		System.out.println("예매 내역 확인");
		System.out.println(movieController.movieList());
		
	}
}
