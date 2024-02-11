package com.service;

import com.common.JDBCTemplate;
import com.dao.ScheduleDao;
import com.dao.TheaterDao;
import com.model.Schedule;
import com.model.Theater;

import java.sql.Connection;
import java.util.ArrayList;

public class ScheduleService {
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

    public Schedule findSeat (int scheduleId, int seat){
        Connection conn = JDBCTemplate.getConnection();
        Schedule schedule = new ScheduleDao().findSeat(conn, scheduleId);

        JDBCTemplate.close(conn);
        return schedule;
    }
}
