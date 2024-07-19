package com.flipkart.business.services;

import com.flipkart.bean.Schedule;
import com.flipkart.business.interfaces.scheduleInterface;

import java.util.ArrayList;
import java.util.List;

public class scheduleService implements scheduleInterface{
    private List<Schedule> schedules = new ArrayList<>();

    @Override
    public void createSchedule(Schedule schedule) {
        schedules.add(schedule);
        System.out.println("Schedule created successfully.");
    }

    @Override
    public Schedule getScheduleById(String scheduleID) {
        return schedules.stream()
                .filter(schedule -> schedule.getScheduleID().equals(scheduleID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return new ArrayList<>(schedules);
    }

    @Override
    public void updateAvailability(String scheduleID, int availability) {
        Schedule schedule = getScheduleById(scheduleID);
        if (schedule != null) {
            schedule.setAvailability(availability);
            System.out.println("Availability updated successfully.");
        } else {
            System.out.println("Schedule not found.");
        }
    }
}
