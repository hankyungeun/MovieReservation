package com.view;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

import com.controller.MovieController;
import com.controller.UserController;
import com.model.Movie;

public class View {
	Scanner sc = new Scanner(System.in);
	UserController userController = new UserController();
	MovieController movieController = new MovieController();

	public void mainMenu() {
		while (true) {
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.print("입력 : ");
			int select = sc.nextInt();
			switch (select) {
				case 1:
					loginView();
					break;
				case 2:
					registerView();
					break;
			}
		}

	}

	// 회원가입
	public void registerView() {
		System.out.print("아이디를 입력하세요 : ");
		String userId = sc.next();
		System.out.print("비밀번호를 입력하세요 : ");
		String name = sc.next();
		System.out.print("이름을 입력하세요 : ");
		String passwd = sc.next();
		userController.creatUser(userId, passwd, name);
	}

	// 로그인
	public void loginView() {
		while (true) {
			System.out.print("아이디 : ");
			String id = sc.next();
			System.out.print("비밀번호 : ");
			String passwd = sc.next();

			if (userController.login(id, passwd) == 1) {
				userMenu();
				return;
			} else if (userController.login(id, passwd) == 2) {
				System.out.println("없는 아이디입니다.");
				System.out.println("계속 로그인 -> 1 입력");
				System.out.println("회원가입 하러 가기 -> 9 입력");
				System.out.print("입력 : ");
				int back = sc.nextInt();
				switch (back) {
					case 1:
						break;
					case 9:
						return;
				}
			} else if (userController.login(id, passwd) == 3) {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		}

	}

	public void userMenu() {
		while (true) {
			System.out.println();
			System.out.println("1. 영화 예매하기");
			System.out.println("2. 예매 내역 확인");
			int menu = sc.nextInt();
			switch (menu) {
				case 1:
					viewMoiveList();

					break;
				case 2:
					viewReservationList();
					break;
			}
		}

	}

	public void viewMoiveList() {
		Object movieListResult = movieController.movieList();
		// 가져온 결과가 List<Movie> 형태인지 확인
		if (movieListResult instanceof List) {
			List<Movie> movies = (List<Movie>) movieListResult;
			System.out.println(String.format("%-5s%-25s%-8s%-7s%-10s", "번호", "영화 제목", "상영 시간", "평점", "감독"));
			for (Movie movie : movies) {
				System.out.println(movie);
			}
			System.out.print("예매할 영화 번호 입력 : ");
			int movieId = sc.nextInt();

		} else {
			// 결과가 List<Movie> 형태가 아닌 경우에 대한 처리
			System.out.println(movieListResult);
		}
	}

	public void viewReservationList() {
	}
}
