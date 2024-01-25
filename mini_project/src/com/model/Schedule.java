package com.model;

import java.sql.Time;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Schedule {
	private String scheduleId;
	private Movie movie;
	private Theater theater;
	private Date date;
	private Time time;
}
