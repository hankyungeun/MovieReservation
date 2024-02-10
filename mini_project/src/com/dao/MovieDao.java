package com.dao;

import com.model.Movie;
import com.common.JDBCTemplate;
import com.model.Movie;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class MovieDao {
    private Properties prop = new Properties();

    public MovieDao() {
        //xml읽기
        try {
            prop.loadFromXML(new FileInputStream("/Users/hangyeong-eun/Documents/dev/MovieReservation/mini_project/resources/query.xml"));

        } catch (InvalidPropertiesFormatException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 영화 전체 목록 조회
     * @param conn : Connection 객체
     * @return list : 회원 전체 목록을 담은 ArryaList<Movie> 타입의 데이터
     */
    public ArrayList<Movie> selectAllList(Connection conn){
        ArrayList<Movie> list = new ArrayList<>();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        //String sql = "SELECT * FROM MEMBER ORDER BY USERNO";
        String sql = prop.getProperty("Movies");
        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery(sql);

            while(rset.next()) {			// .next():데이터가 있는지 여부 체크
                Movie movie = new Movie(
                        rset.getInt("movie_Id"),
                        rset.getString("MOVIE_TITLE"),
                        rset.getInt("RUNNING_TIME"),
                        rset.getInt("GRADE"),
                        rset.getString("DIRECTOR")
                );
                list.add(movie);

            }

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        return list;
    }

}
