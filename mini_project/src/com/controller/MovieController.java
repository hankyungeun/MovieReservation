package com.controller;

import java.util.ArrayList;
import java.util.List;
import com.model.Movie;

public class MovieController {

	public Object movieList(){
		List<Movie> movies = new ArrayList<>();
		Movie movie1 = new Movie("1","윙카",107, 5, "폴 킹");
		Movie movie2 = new Movie("2","귀멸의 칼날",100, 1, "폴 킹");
		Movie movie3 = new Movie("3","도그맨",97, 4, "폴 킹");
		Movie movie4 = new Movie("4","외계인",155, 2, "폴 킹");
		Movie movie5 = new Movie("5","정글번치",157, 3, "폴 킹");

		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		movies.add(movie4);
		movies.add(movie5);

        return movies.isEmpty() ? "Nothing found" : movies;
	}
}
