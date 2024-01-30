package com.controller;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.model.Schedule;

public class ScheduleController {
    public Object scheduleList(int movieId) throws ParseException {
        List<Schedule> scheduleList = new ArrayList<>();
        // 날짜 문자열을 Date 객체로 변환
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = new Date(dateFormat.parse("2024-01-29").getTime());
        Date date2 = new Date(dateFormat.parse("2024-01-30").getTime());
        Date date3 = new Date(dateFormat.parse("2024-01-31").getTime());

        // 시간 문자열을 Time 객체로 변환
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Time startTime1 = new Time(timeFormat.parse("14:00:00").getTime());
        Time endTime1 = new Time(timeFormat.parse("16:00:00").getTime());

        Time startTime2 = new Time(timeFormat.parse("17:30:00").getTime());
        Time endTime2 = new Time(timeFormat.parse("19:30:00").getTime());

        Time startTime3 = new Time(timeFormat.parse("20:00:00").getTime());
        Time endTime3 = new Time(timeFormat.parse("22:00:00").getTime());

        Schedule schedule1 = new Schedule("1", 1, 1, date1, startTime1, endTime1);
        Schedule schedule2 = new Schedule("2", 2, 2, date2, startTime2, endTime2);
        Schedule schedule3 = new Schedule("3", 3, 3, date3, startTime3, endTime3);

        scheduleList.add(schedule1);
        scheduleList.add(schedule2);
        scheduleList.add(schedule3);

        List<Schedule> filteredList = new ArrayList<>();
        for (Schedule schedule : scheduleList) {
            if (schedule.getMovieId() == movieId) {
                System.out.println("Schedule ID: " + schedule.getScheduleId());
                System.out.println("Date: " + schedule.getDate());
                System.out.println("상영관 : " + schedule.getTheaterNum());
                System.out.println("StartTime: " + schedule.getStartTime());
                System.out.println("EndTime: " + schedule.getEndTime());
                System.out.println("----------------------");
            }
        }

        return filteredList.isEmpty() ? "No schedules found for movie ID " + movieId : filteredList;

    }
}
