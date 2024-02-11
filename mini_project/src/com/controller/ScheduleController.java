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
    }
}
