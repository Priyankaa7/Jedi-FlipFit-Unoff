package com.flipkart.business.interfaces;

import com.flipkart.bean.Schedule;

import java.util.List;

public interface scheduleInterface {
    void createSchedule(Schedule schedule);
    Schedule getScheduleById(String scheduleID);
    List<Schedule> getAllSchedules();
    void updateAvailability(String scheduleID, int availability);
}


