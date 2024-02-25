package com.controller;

import java.util.List;

import com.model.Schedule;
import com.service.ScheduleService;
import com.view.View;

public class ScheduleController {
    public boolean findSchedule(int movieId) {

        List<Schedule> scheduleList = new ScheduleService().findSchedules(movieId);

        if (scheduleList.isEmpty()) {
            new View().displayNoData("스케줄이 없습니다.");
            return false;
        } else {
            new View().displaySchedules(scheduleList);
            return true;
        }
    }

    public boolean findSeat(int scheduleId, int seat){
        Schedule schedule = new ScheduleService().findSeat(scheduleId, seat);
        if(schedule.getTheater().getSeat() < seat){
            return false;
        }
        else return true;
    }
}
