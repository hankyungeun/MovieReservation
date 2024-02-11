package com.dao;

import com.common.JDBCTemplate;
import com.model.Schedule;
import com.model.Theater;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class TheaterDao {

    private Properties prop = new Properties();

    public TheaterDao() {
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

    public Theater findTheaterByNum(Connection conn, int num) {
        Theater theater = null;

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String sql = prop.getProperty("findTheaterByNum");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            rset = pstmt.executeQuery();

            if (rset.next()) {
                Theater t = new Theater(
                        rset.getInt("THEATER_NUM"),
                        rset.getInt("SEAT")
                );
                theater = t;

            }

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        return theater;
    }

}
