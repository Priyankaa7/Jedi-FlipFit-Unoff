package com.flipkart.business.interfaces;

import com.flipkart.bean.User;

public interface gymCustomerInterface {
    void displayAvailableGyms();
    void bookSlot();
    void cancelBooking();
    void displayBookings();
    void displayProfile(User user);
}

