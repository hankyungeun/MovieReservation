package com.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.controller.MovieController;
import com.controller.ReservationController;
import com.controller.ScheduleController;
import com.controller.UserController;
import com.model.Movie;
import com.model.Reservation;
import com.model.Schedule;
import com.model.User;
import com.service.UserService;

public class View {
	private String loginedUser;
	Scanner sc = new Scanner(System.in);
	UserController userController = new UserController();
	MovieController movieController = new MovieController();
	ScheduleController scheduleController = new ScheduleController();
	ReservationController reservationController = new ReservationController();

	public void mainMenu() {
		while (true) {
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("0. 프로그램 종료");
			System.out.print("입력 : ");
			int select = sc.nextInt();
			switch (select) {
				case 1:
					loginView();
					break;
				case 2:
					registerView();
					break;
				case 0:
					return;
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
			System.out.print("\n아이디 : ");
			String userId = sc.next();
			System.out.print("비밀번호 : ");
			String passwd = sc.next();
			if(userController.login(userId, passwd)){
				loginedUser = userId;
				userMenu();


			} else {
				System.out.println("\n1 : 로그인 계속 진행");
				System.out.println("2 : 뒤로가기");
				System.out.print("입력 : ");
				int select = sc.nextInt();
				if(select == 2){
					return;
				}
			}

		}
	}
	// 로그인 성공 시 처리
	public void displayUser(User user) {
		System.out.println("\n로그인 되었습니다.");
		System.out.println(user.getName() + "님 반갑습니다.");
	}

	public void userMenu() {
		while (true) {
			System.out.println();
			System.out.println("1. 영화 예매하기");
			System.out.println("2. 예매 내역 확인");
			System.out.println("3. 로그아웃");
			System.out.print("메뉴 입력 : ");
			int menu = sc.nextInt();
			switch (menu) {
				case 1:
					// 영화 내역 보여주기
					movieController.movies();
					// 영화 예매 함수 호출
					reservationMovie();
					break;
				case 2:
					Optional.ofNullable(loginedUser).ifPresentOrElse(
							lu -> {
								reservationController.findReservation(lu);
							}, () -> System.out.println("UNKNOWN_USER")
					);
					break;
				case 3: return;
			}
		}
	}
	public void displayMovies(ArrayList<Movie> list) {
		System.out.println("\n조회된 결과는 다음과 같습니다.");
//		System.out.println(String.format("%-5s%-25s%-8s%-7s%-10s", "번호", "영화 제목", "상영 시간", "평점", "감독"));
		for(Movie movie : list) {
			System.out.println("번호 : " + movie.getMovieId());
			System.out.println("영화제목 : " + movie.getMovieTitle());
			System.out.println("상영 시간 : " + movie.getRunningTime());
			System.out.println("평점 : " + movie.getGrade());
			System.out.println("감독 : " + movie.getDirector());
			System.out.println("----------------------");
		}
	}

	// 영화 예매 함수
	public void reservationMovie(){
		while (true){
			System.out.print("\n예매할 영화 번호 입력 : ");
			int movieNum = sc.nextInt();
			if(!scheduleController.findSchedule(movieNum)) break;
			System.out.print("스케줄 번호 입력 : ");
			int scNum = sc.nextInt();
			System.out.print("좌석 번호 입력 : ");
			int seatNum = sc.nextInt();
			if(seatNum < 0){
				System.out.println("유효한 숫자 입력");
			} else{
				if(scheduleController.findSeat(scNum, seatNum)) {
					reservationController.reserveMovie(scNum, seatNum, loginedUser);
					return;
				}
				else{
					System.out.println("좌석 번호는 Max Seat를 초과할 수 없습니다.");
					break;
				}
			}
		}
	}

	public void displaySchedules(List<Schedule> list) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println("\n조회된 스케줄 결과는 다음과 같습니다.");
		for(Schedule schedule : list) {
			System.out.println("Schedule ID: " + schedule.getScheduleId());
            System.out.println("상영관 : " + schedule.getTheaterNum());
			System.out.println("날짜 : " + schedule.getStartTime());
            System.out.println("시작 시간 : " + sdf.format(schedule.getStartTime()));
            System.out.println("종료 시간 : " + sdf.format(schedule.getEndTime()));
			System.out.println("Max Seat : " + schedule.getTheater().getSeat());
            System.out.println("----------------------");
		}
	}

	public void displayReservation(List<Reservation> list) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println("\n조회된 예매 내역은 다음과 같습니다.");
		for(Reservation reservation : list) {
			System.out.println("예약 번호: " + reservation.getReservationId());
			System.out.println("상영관 : " + reservation.getSchedule().getTheaterNum());
			System.out.println("날짜 : " + reservation.getSchedule().getStartTime());
			System.out.println("시작 시간 : " + sdf.format(reservation.getSchedule().getStartTime()));
			System.out.println("종료 시간 : " + sdf.format(reservation.getSchedule().getEndTime()));
			System.out.println("좌석 번호 : " + reservation.getSeat());
			System.out.println("----------------------");
		}
	}

	public void displaySuccess(String message) {
		System.out.println("\n요청 성공 : " + message);
	}
	public void displayFailed(String message) {
		System.out.println("\n요청 실패 : " + message);
		System.out.println();
	}
	public void displayNoData(String message) {
		System.out.println("\n결과 없음 : " + message);
	}
}
