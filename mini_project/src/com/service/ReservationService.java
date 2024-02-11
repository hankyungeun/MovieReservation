package com.service;

import com.common.JDBCTemplate;
import com.dao.ReservationDao;
import com.dao.ScheduleDao;
import com.dao.TheaterDao;
import com.model.Reservation;
import com.model.Schedule;
import com.model.Theater;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

public class ReservationService {
    public ArrayList<Reservation> findReservation(String userId) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<Reservation> list = new ReservationDao().findReservation(conn, userId);
        JDBCTemplate.close(conn);

        return list;
    }

    public Map<Integer, Reservation> reserveMovie(String userId, int scNum, int seat) {
        Connection conn = JDBCTemplate.getConnection();
        Map<Integer, Reservation> reservation = new ReservationDao().findByScheduleNumAndUserIdAndSeatNum(conn, userId, scNum, seat);
        JDBCTemplate.close(conn);
        return reservation;
    }
}
