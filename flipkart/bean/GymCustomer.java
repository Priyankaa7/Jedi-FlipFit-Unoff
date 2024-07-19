package com.flipkart.bean;

public class GymCustomer {
    private User user;

    public GymCustomer(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}