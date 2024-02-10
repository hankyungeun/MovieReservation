package com.controller;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.model.Movie;
import com.model.Schedule;
import com.service.MovieService;
import com.service.ScheduleService;
import com.view.View;

public class ScheduleController {
    public void findSchedule(int movieId) {

        List<Schedule> scheduleList = new ScheduleService().findSchedules(movieId);

        if (scheduleList.isEmpty()) {
            new View().displayNoData("스케줄이 없습니다.");
        } else {
            new View().displaySchedules(scheduleList);
        }


//        // 날짜 문자열을 Date 객체로 변환
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date1 = new Date(dateFormat.parse("2024-01-29").getTime());
//        Date date2 = new Date(dateFormat.parse("2024-01-30").getTime());
//        Date date3 = new Date(dateFormat.parse("2024-01-31").getTime());
//
//        // 시간 문자열을 Time 객체로 변환
//        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
//        Time startTime1 = new Time(timeFormat.parse("14:00:00").getTime());
//        Time endTime1 = new Time(timeFormat.parse("16:00:00").getTime());
//
//        Time startTime2 = new Time(timeFormat.parse("17:30:00").getTime());
//        Time endTime2 = new Time(timeFormat.parse("19:30:00").getTime());
//
//        Time startTime3 = new Time(timeFormat.parse("20:00:00").getTime());
//        Time endTime3 = new Time(timeFormat.parse("22:00:00").getTime());
//
//
//        List<Schedule> filteredList = new ArrayList<>();
//        for (Schedule schedule : scheduleList) {
//            if (schedule.getMovieId() == movieId) {
//                System.out.println("Schedule ID: " + schedule.getScheduleId());
//                System.out.println("Date: " + schedule.getDate());
//                System.out.println("상영관 : " + schedule.getTheaterNum());
//                System.out.println("StartTime: " + schedule.getStartTime());
//                System.out.println("EndTime: " + schedule.getEndTime());
//                System.out.println("----------------------");
//            }
//        }
//
//        return filteredList.isEmpty() ? "No schedules found for movie ID " + movieId : filteredList;

    }
}
