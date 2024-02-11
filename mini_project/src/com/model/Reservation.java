package com.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class Reservation {
	private String reservationId;
	private String userId;
	private int scheduleId;
	private int seat;
	private Schedule schedule;
	private User user;

	public Reservation(String reservationId, String userId, int scheduleId, int seat) {
		this.reservationId = reservationId;
		this.userId = userId;
		this.scheduleId = scheduleId;
		this.seat = seat;
	}

	public Reservation(String reservationId, String userId, int scheduleId, int seat, int theaterNum, Date startTime, Date endTime) {
		this(reservationId,userId,scheduleId,seat);
		this.schedule = new Schedule();
		this.schedule.setTheaterNum(theaterNum);
		this.schedule.setStartTime(startTime);
		this.schedule.setEndTime(endTime);
	}

}