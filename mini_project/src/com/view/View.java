package com.view;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.controller.MovieController;
import com.controller.ScheduleController;
import com.controller.UserController;
import com.model.Movie;
import com.model.User;

public class View {
	Scanner sc = new Scanner(System.in);
	UserController userController = new UserController();
	MovieController movieController = new MovieController();
	ScheduleController scheduleController = new ScheduleController();

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
		userController.createUser(userId, passwd, name);
	}

	// 로그인
	public void loginView() {
		while (true) {
			System.out.print("아이디 : ");
			String userId = sc.next();
			System.out.print("비밀번호 : ");
			String passwd = sc.next();
			if(userController.login(userId, passwd)){
				userMenu();
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
					// 영화 내역 보여주기
					movieController.movies();
					// 영화 예매 함수 호출
					reservationMovie();
					break;
				case 2:
					viewReservationList();
					break;
			}
		}
	}
	public void reservationMovie(){
		System.out.println("영화 번호 입력");
		int movieNum = sc.nextInt();
	}

	public void displayNoData(String message) {
		System.out.println("\n 결과 없음 : message");
	}

	public void displayUser(User user) {
		System.out.println("\n 로그인 되었습니다.");
		System.out.println(user.getName() + "님 반갑습니다.");
	}

	public void displayList(ArrayList<User> list) {
		System.out.println("\n 조회된 결과는 다음과 같습니다.");
		for(User user : list) {
			System.out.println(user);
		}
	}
	public void displayMovies(ArrayList<Movie> list) {
		System.out.println("\n 조회된 결과는 다음과 같습니다.");
		for(Movie movie : list) {
			System.out.println(movie);
		}
	}

//	public void viewMoiveList() {
//		ArrayList<Movie> movieListResult = movieController.movies();
//		// 가져온 결과가 List<Movie> 형태인지 확인
//		if (movieListResult instanceof List) {
//			List<Movie> movies = (List<Movie>) movieListResult;
//			System.out.println(String.format("%-5s%-25s%-8s%-7s%-10s", "번호", "영화 제목", "상영 시간", "평점", "감독"));
//			for (Movie movie : movies) {
//				System.out.println(movie);
//			}
//			System.out.print("예매할 영화 번호 입력 : ");
//			int movieId = sc.nextInt();
//			viewScheduleList(movieId);
//
//		} else {
//			// 결과가 List<Movie> 형태가 아닌 경우에 대한 처리
//			System.out.println(movieListResult);
//		}
//	}

	public void displaySuccess(String message) {
		System.out.println("\n 요청 성공 : " + message);
	}

	/**
	 * 요청 처리 후 실패했을 경우 사용자가 보게될 화면
	 * @param message : 객체 별 실패 메시지
	 */
	public void displayFailed(String message) {
		System.out.println("\n 요청 실패 : " + message);
	}

	public void viewScheduleList(int movieId) {
		try {
			scheduleController.scheduleList(movieId);
			System.out.print("스케줄 번호 입력 : ");
			int scheduleId = sc.nextInt();

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void viewReservationList() {
	}
}
