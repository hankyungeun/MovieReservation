package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.model.Movie;

public class MovieController {
	public Object movieList(){
		List<Movie> movies = new ArrayList<>();



        return movies.isEmpty() ? "Nothing found" : movies;
	}
}
