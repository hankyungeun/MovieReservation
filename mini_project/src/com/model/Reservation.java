package com.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reservation {
	private String userId;
	private String name;
	private String movieTitle;
	private Date date;
}
