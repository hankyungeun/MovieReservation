package com.dao;

import com.common.JDBCTemplate;
import com.model.Reservation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ReservationDao {
    private Properties prop = new Properties();

    public ReservationDao() {
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

    // 예매 내역 확인
    public ArrayList<Reservation> findReservation(Connection conn, String userId){
        ArrayList<Reservation> list = new ArrayList<>();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String sql = prop.getProperty("findReservationByUserId");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rset = pstmt.executeQuery();

            while(rset.next()) {			// .next():데이터가 있는지 여부 체크
                Reservation reservation = new Reservation(
                        rset.getString("RESERVATION_ID"),
                        rset.getString("USER_ID"),
                        rset.getInt("SCHEDULE_ID"),
                        rset.getInt("SEAT"),
                        rset.getInt("THEATER_NUM"),
                        rset.getDate("START_TIME"),
                        rset.getDate("END_TIME")
                );
                list.add(reservation);

            }

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        return list;
    }

    public Map<Integer, Reservation> findByScheduleNumAndUserIdAndSeatNum(Connection conn, String userId, int scheduleNum, int seat) {
        Map<Integer, Reservation> resultMap = new HashMap<>();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String sql = prop.getProperty("findByScheduleNumAndSeatNum");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, scheduleNum);
            pstmt.setInt(2, seat);
            rset = pstmt.executeQuery();

            if(rset.next()) {
                Reservation reservation = new Reservation(
                        rset.getString("RESERVATION_ID"),
                        rset.getString("USER_ID"),
                        rset.getInt("SCHEDULE_ID"),
                        rset.getInt("SEAT")
                );
                resultMap.put(0, reservation);
            } else {
                // create
                Reservation r = new Reservation(UUID.randomUUID().toString(), userId, scheduleNum, seat);

                String insertSql = prop.getProperty("insertReservation");
                PreparedStatement statement = conn.prepareStatement(insertSql);
                statement.setString(1, r.getReservationId());
                statement.setInt(2, r.getScheduleId());
                statement.setString(3, r.getUserId());
                statement.setInt(4, r.getSeat());
                ResultSet resultSet = statement.executeQuery();;
                resultMap.put(1, r);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        return resultMap;
    }
}
