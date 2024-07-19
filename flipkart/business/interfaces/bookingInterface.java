package com.flipkart.business.interfaces;

import com.flipkart.bean.Booking;

import java.util.List;

public interface bookingInterface {
    void createBooking(Booking booking);
    Booking getBookingById(int bookingID);
    List<Booking> getBookingsByCustomerId(int customerID);
    void cancelBooking(int bookingID);
}
