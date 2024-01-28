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

	public Movie(String movieId, String movieTitle, int runningTime, int grade, String director) {
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.runningTime = runningTime;
		this.grade = grade;
		this.director = director;
	}

	public String toString(){
		return "";
	}
}
