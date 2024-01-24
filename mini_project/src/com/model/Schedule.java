package com.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Schedule {
	private String scheduleId;
	private String movieId;
	private int theaterNum;
	private Date date;
}
