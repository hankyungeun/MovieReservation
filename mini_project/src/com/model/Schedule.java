package com.model;

import java.sql.Time;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Data
@RequiredArgsConstructor
public class Schedule {
	private int scheduleId;
	private int movieId;
	private int theaterNum;

	private Theater theater;

	@CreationTimestamp
	private Date startTime;

	private Date endTime;

	public Schedule(int scheduleId, int movieId, int theaterNum, Date startTime, Date endTime) {
		this.scheduleId = scheduleId;
		this.movieId = movieId;
		this.theaterNum = theaterNum;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Schedule(int scheduleId, int movieId, int theaterNum, Theater theater, Date startTime, Date endTime) {
		this(scheduleId, movieId, theaterNum, startTime, endTime);
		this.theater = theater;
	}

	public Theater getAssociatedTheater() {
		return theater;
	}
}
