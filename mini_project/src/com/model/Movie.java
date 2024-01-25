package com.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {
	private String movieId;
	private String movieTitle;
	private int runningTime;
	private int grade;
	private String director;
}
