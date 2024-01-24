package com.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {
	private String MovieId;
	private String movieTitle;
	private String genre;
	private int runningTime;
	private int score;
	private String director;
}
