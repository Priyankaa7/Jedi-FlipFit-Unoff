package com.flipkart.business.interfaces;

import com.flipkart.bean.TimeSlot;

import java.time.LocalDate;
import java.util.List;

public interface timeSlotInterface {
    void createTimeSlot(TimeSlot timeSlot);
    TimeSlot getTimeSlotById(int slotID);
    List<TimeSlot> getTimeSlotsByGymId(int gymID);
    List<TimeSlot> getTimeSlotsByDay(LocalDate day);
    void updateAvailableSeats(int slotID, int availableSeats);
}
