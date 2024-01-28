package com.model;

import java.util.Date;

import lombok.Data;

@Data
public class Reservation {
	private String reservationId;
	private User user;
	private String userId;
	private Schedule schedule;
	private String scheduleId;
}