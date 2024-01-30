package com.run;

import java.text.ParseException;

import com.controller.ScheduleController;
import com.view.View;

public class Run {

	public static void main(String[] args) throws ParseException {
		View view = new View();
		// view.mainMenu();
		// view.viewMoiveList();
		ScheduleController sc = new ScheduleController();
		System.err.println(sc.scheduleList(3));
	}

}
