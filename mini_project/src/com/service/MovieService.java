package com.service;

import com.common.JDBCTemplate;
import com.dao.MovieDao;
import com.model.Movie;

import java.sql.Connection;
import java.util.ArrayList;

public class MovieService {
    public ArrayList<Movie> selectAllList() {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<Movie> list = new MovieDao().selectAllList(conn);
        JDBCTemplate.close(conn);

        return list;
    }
}
