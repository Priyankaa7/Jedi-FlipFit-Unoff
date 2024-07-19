package com.flipkart.business.services;

import com.flipkart.bean.Booking;
import com.flipkart.business.interfaces.bookingInterface;

import java.util.ArrayList;
import java.util.List;

public class bookingService implements bookingInterface{
    private List<Booking> bookings = new ArrayList<>();

    @Override
    public void createBooking(Booking booking) {
        bookings.add(booking);
        System.out.println("Booking created successfully.");
    }

    @Override
    public Booking getBookingById(int bookingID) {
        return bookings.stream()
                .filter(booking -> booking.getBookingID() == bookingID)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Booking> getBookingsByCustomerId(int customerID) {
        List<Booking> customerBookings = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getCustomerID() == customerID) {
                customerBookings.add(booking);
            }
        }
        return customerBookings;
    }

    @Override
    public void cancelBooking(int bookingID) {
        bookings.removeIf(booking -> booking.getBookingID() == bookingID);
        System.out.println("Booking cancelled successfully.");
    }
}
