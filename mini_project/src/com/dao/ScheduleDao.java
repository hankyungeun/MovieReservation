package com.dao;

import com.common.JDBCTemplate;
import com.model.Schedule;

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

public class ScheduleDao {
    private Properties prop = new Properties();

    public ScheduleDao() {
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

    public Schedule findSeat(Connection conn, int scheduleId){
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("findSeat");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, scheduleId);
            rset = pstmt.executeQuery();

            if(rset.next()) {			// .next():데이터가 있는지 여부 체크
                Schedule schedule = new Schedule(
                        rset.getInt("SCHEDULE_ID"),
                        rset.getInt("MOVIE_ID"),
                        rset.getInt("THEATER_NUM"),
                        rset.getDate("START_TIME"),
                        rset.getDate("END_TIME"),
                        rset.getInt("SEAT")
                );
                return schedule;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        return null;
    }


    public ArrayList<Schedule> findSchedules(Connection conn, int movieId){
        ArrayList<Schedule> list = new ArrayList<>();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String sql = prop.getProperty("findScheduleByMovieNum");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, movieId);
            rset = pstmt.executeQuery();

            while(rset.next()) {			// .next():데이터가 있는지 여부 체크
                Schedule schedule = new Schedule(
                        rset.getInt("SCHEDULE_ID"),
                        rset.getInt("MOVIE_ID"),
                        rset.getInt("THEATER_NUM"),
                        rset.getDate("START_TIME"),
                        rset.getDate("END_TIME")
                );
                list.add(schedule);

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
