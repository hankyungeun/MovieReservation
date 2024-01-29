package com.model;

import lombok.Data;

@Data
public class Movie {
	private int movieId;
	private String movieTitle;
	private int runningTime;
	private int grade;
	private String director;

	public Movie(int movieId, String movieTitle, int runningTime, int grade, String director) {
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.runningTime = runningTime;
		this.grade = grade;
		this.director = director;
	}

	@Override
	public String toString() {
		String formattedMovieId = String.format("%-3s", movieId);
		String formattedMovieTitle = String.format("%-23s", movieTitle);
		String formattedRunningTime = String.format("%-7s", runningTime);
		String formattedGrade = String.format("%-6s", grade);
		String formattedDirector = String.format("%-10s", director);
		return formattedMovieId + "\t" + formattedMovieTitle + "\t" + formattedRunningTime + "\t" + formattedGrade
				+ "\t"
				+ formattedDirector;
	}
}
