package com.flipkart.business.services;

import com.flipkart.bean.TimeSlot;
import com.flipkart.business.interfaces.timeSlotInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class timeSlotService implements timeSlotInterface {
    private List<TimeSlot> timeSlots = new ArrayList<>();

    @Override
    public void createTimeSlot(TimeSlot timeSlot) {
        timeSlots.add(timeSlot);
        System.out.println("TimeSlot created successfully.");
    }

    @Override
    public TimeSlot getTimeSlotById(int slotID) {
        return timeSlots.stream()
                .filter(timeSlot -> timeSlot.getSlotID() == slotID)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<TimeSlot> getTimeSlotsByGymId(int gymID) {
        List<TimeSlot> gymTimeSlots = new ArrayList<>();
        for (TimeSlot timeSlot : timeSlots) {
            if (timeSlot.getGymID() == gymID) {
                gymTimeSlots.add(timeSlot);
            }
        }
        return gymTimeSlots;
    }

    @Override
    public List<TimeSlot> getTimeSlotsByDay(LocalDate day) {
        List<TimeSlot> dayTimeSlots = new ArrayList<>();
        for (TimeSlot timeSlot : timeSlots) {
            if (timeSlot.getDay().equals(day)) {
                dayTimeSlots.add(timeSlot);
            }
        }
        return dayTimeSlots;
    }

    @Override
    public void updateAvailableSeats(int slotID, int availableSeats) {
        TimeSlot timeSlot = getTimeSlotById(slotID);
        if (timeSlot != null) {
            timeSlot.setAvailableSeats(availableSeats);
            System.out.println("Available seats updated successfully.");
        } else {
            System.out.println("TimeSlot not found.");
        }
    }
}
