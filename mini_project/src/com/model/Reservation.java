package com.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class Reservation {
	private String reservationId;
	private User user;
	private String userId;
	private Schedule schedule;
	private int scheduleId;
	private int seat;

	public Reservation(String reservationId, String userId, int scheduleId, int seat) {
		this.reservationId = reservationId;
		this.userId = userId;
		this.scheduleId = scheduleId;
		this.seat = seat;
	}
}