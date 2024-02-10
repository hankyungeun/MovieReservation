package com.controller;

import java.util.ArrayList;
import com.model.Movie;
import com.service.MovieService;
import com.view.View;

public class MovieController {
	public void movies() {
		ArrayList<Movie> list = new MovieService().selectAllList();

		if (list.isEmpty()) {
			new View().displayNoData("개봉중인 영화가 없습니다.");
		} else {
			new View().displayMovies(list);
		}
	}
}
