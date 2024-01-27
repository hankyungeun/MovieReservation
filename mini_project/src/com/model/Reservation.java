package com.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reservation {
	private String reservationId;
	private User user;
	private String userId;
	private Schedule schedule;
	private String scheduleId;
}