package com.model;

import java.sql.Time;
import java.util.Date;

import lombok.Data;

@Data
public class Schedule {
	private String scheduleId;
	private int movieId;
	private int theaterNum;
	private Movie movie;
	private Theater theater;
	private Date date;
	private Time startTime;
	private Time endTime;

	public Schedule(String scheduleId, int movieId, int theaterNum, Date date, Time startTime, Time endTime) {
		this.scheduleId = scheduleId;
		this.movieId = movieId;
		this.theaterNum = theaterNum;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Schedule(String scheduleId, int movieId, int theaterNum, Movie movie, Theater theater, Date date,
			Time startTime, Time endTime) {
		this(scheduleId, movieId, theaterNum, date, startTime, endTime);
		this.movie = movie;
		this.theater = theater;
	}

	public Theater getAssociatedTheater() {
		return theater;
	}
}
