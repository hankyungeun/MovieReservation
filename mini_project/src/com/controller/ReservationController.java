package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.model.Reservation;
import com.service.ReservationService;
import com.view.View;

public class ReservationController {
	public void findReservation(String userId) {

		List<Reservation> reservations = new ReservationService().findReservation(userId);

		if (reservations.isEmpty()) {
			new View().displayNoData("예매내역이 없습니다.");
		} else {
			new View().displayReservation(reservations);
		}
	}

	public void reserveMovie(int scheduleNum, int seatNum, String userId) {
		Map<Integer, Reservation> r = new ReservationService().reserveMovie(userId, scheduleNum, seatNum);
		if (r.containsKey(0)) {
			new View().displayFailed("이미 예매된 번호입니다.");
		} else {
			new View().displaySuccess("예매 성공");
		}
	}
}
