package com.flipkart.business.services;

import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.User;
import com.flipkart.business.interfaces.gymCustomerInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gymCustomerService implements gymCustomerInterface {

    private GymCustomer gymCustomer;
    private List<String[]> availableGyms;
    private List<String[]> bookedSlots;

    public gymCustomerService(User user) {
        this.gymCustomer = new GymCustomer(user);
        initializeGyms();
        bookedSlots = new ArrayList<>();
    }

    private void initializeGyms() {
        availableGyms = new ArrayList<>();
        availableGyms.add(new String[]{"1", "Gold's Gym", "New York"});
        availableGyms.add(new String[]{"2", "Planet Fitness", "Los Angeles"});
    }



    @Override
    public void displayAvailableGyms() {
        System.out.println("GymID\tGymName\t\tLocation");
        System.out.println("-----------------------------------------------------------");
        for (String[] gym : availableGyms) {
            System.out.println(gym[0] + "\t" + gym[1] + "\t\t" + gym[2]);
        }
    }

    @Override
    public void bookSlot() {
        Scanner in = new Scanner(System.in);
        System.out.println("\n********************* Available Slots ****************\n");
        System.out.println("Slot No.\tTimings(24hrs)\t\tGymID\n------------------------------------------------------");

        for (int i = 0; i < availableGyms.size(); i++) {
            String[] gym = availableGyms.get(i);
            System.out.println((i + 1) + "\t" + "10:00-11:00" + "\t\t" + gym[0] + "\t" + gym[1]);
        }

        System.out.println("Please enter the slot number you want to book: ");
        int slotIndex = in.nextInt();
        in.nextLine();

        if (slotIndex > 0 && slotIndex <= availableGyms.size()) {
            String[] selectedGym = availableGyms.get(slotIndex - 1);
            bookedSlots.add(selectedGym);
            availableGyms.remove(selectedGym);
            System.out.println("Slot booked successfully.");
        } else {
            System.out.println("Unknown Slot!");
        }

    }

    @Override
    public void cancelBooking() {
        Scanner in = new Scanner(System.in);
        System.out.println("\n********************* Your Bookings ****************\n");

        if (bookedSlots.isEmpty()) {
            System.out.println("You have no bookings.");
            return;
        }

        System.out.println("Booking No.\tTimings(24hrs)\t\tGymID\tGymName\t\tLocation\n------------------------------------------------------");
        for (int i = 0; i < bookedSlots.size(); i++) {
            String[] booking = bookedSlots.get(i);
            System.out.println((i + 1) + "\t" + "10:00-11:00" + "\t\t" + booking[0] + "\t" + booking[1] + "\t\t" + booking[2]);
        }

        System.out.println("\nPlease enter the booking number to be cancelled: ");
        int bookingIndex = in.nextInt();
        in.nextLine();

        if (bookingIndex > 0 && bookingIndex <= bookedSlots.size()) {
            String[] cancelledGym = bookedSlots.get(bookingIndex - 1);
            availableGyms.add(cancelledGym);
            bookedSlots.remove(cancelledGym);
            System.out.println("Booking cancelled successfully.");
        } else {
            System.out.println("No such booking number exists!");
        }

    }

    @Override
    public void displayBookings() {
        // TODO Auto-generated method stub
        System.out.println("\n********************* Your Bookings ****************\n");

        if (bookedSlots.isEmpty()) {
            System.out.println("You have no bookings.");
            return;
        }

        System.out.println("Booking No.\tTimings(24hrs)\t\tGymID\tGymName\t\tLocation\n------------------------------------------------------");
        for (int i = 0; i < bookedSlots.size(); i++) {
            String[] booking = bookedSlots.get(i);
            System.out.println((i + 1) + "\t" + "10:00-11:00" + "\t\t" + booking[0] + "\t" + booking[1] + "\t\t" + booking[2]);
        }
    }

    @Override
    public void displayProfile(User user) {
        System.out.println("Profile details:");
        System.out.println("Username: " + user.getUsername());
        System.out.println("Role: " + user.getRole());

    }
}
