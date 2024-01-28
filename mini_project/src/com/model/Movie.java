package com.model;

import lombok.Data;

@Data
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

	@Override
	public String toString(){
		String formattedMovieId = String.format("%-3s", movieId);
		String formattedMovieTitle = String.format("%-20s", movieTitle);
		String formattedDirector = String.format("%-10s", director);
		return formattedMovieId + "\t" + formattedMovieTitle + "\t" + runningTime + "\t" + grade + "\t" + formattedDirector;
	}


}
