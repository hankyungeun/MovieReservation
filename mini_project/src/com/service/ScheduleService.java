package com.service;

import com.common.JDBCTemplate;
import com.dao.ScheduleDao;
import com.dao.TheaterDao;
import com.model.Movie;
import com.model.Schedule;
import com.model.Theater;

import java.sql.Connection;
import java.util.ArrayList;

public class ScheduleService {
    public ArrayList<Schedule> schedules() {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<Schedule> list = new ScheduleDao().schedules(conn);
        JDBCTemplate.close(conn);

        return list;
    }

    public ArrayList<Schedule> findSchedules(int movieId) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<Schedule> list = new ScheduleDao().findSchedules(conn, movieId);
        if (!list.isEmpty()) {
            list.forEach(l -> {
                int num = l.getTheaterNum();
                Theater t = new TheaterDao().findTheaterByNum(conn, num);
                if (t != null) l.setTheater(t);
            });
        }
        JDBCTemplate.close(conn);

        return list;
    }
}
