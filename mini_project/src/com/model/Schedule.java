package com.model;

import java.sql.Time;
import java.util.Date;

import lombok.Data;

@Data
public class Schedule {
	private String scheduleId;
	private String movieId;
	private int theaterNum;
	private Movie movie;
	private Theater theater;
	private Date date;
	private Time time;
}
