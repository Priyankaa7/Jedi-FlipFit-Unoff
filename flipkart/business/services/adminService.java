package com.flipkart.business.services;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.interfaces.adminInterface;

import java.util.ArrayList;
import java.util.List;

public class adminService implements adminInterface {
    @Override
    public List<GymOwner> getPendingGymOwnerApprovals() {
        List<GymOwner> list = new ArrayList<>();
        list.add(new GymOwner(1, "abc", "abc", "1234-5678-9123", "GSTIN1234", "PAN1234", "Address 1", "100001"));
        list.add(new GymOwner(2, "xyz", "xyz", "9876-5432-1987", "GSTIN5678", "PAN5678", "Address 2", "200002"));
        return list;
    }

    @Override
    public void handleGymOwnerRequest(int gymOwnerId, int newStatus) {
        System.out.println("Gym owner request for ID " + gymOwnerId + " has been " + (newStatus == 1 ? "approved" : "rejected") + ".");
    }

    @Override
    public void approveAllGymOwners() {
        System.out.println("All pending gym owner registration requests have been approved.");
    }

    @Override
    public List<GymCenter> getPendingGymRegistrationRequests() {
        // Simulated data for pending gym registration requests
        List<GymCenter> list = new ArrayList<>();
        GymCenter gymCenter1 = new GymCenter();
        gymCenter1.setGymName("Fitness First");
        gymCenter1.setLocation("Bellandur");
        gymCenter1.setNoOfSeats(50);
        gymCenter1.setGymOwnerID("1");
        list.add(gymCenter1);

        GymCenter gymCenter2 = new GymCenter();
        gymCenter2.setGymName("Gold's Gym");
        gymCenter2.setLocation("Koramangala");
        gymCenter2.setNoOfSeats(60);
        gymCenter2.setGymOwnerID("2");
        list.add(gymCenter2);

        return list;
    }

    @Override
    public void handleGymRegistrationRequest(int gymId, int newStatus) {
        System.out.println("Gym registration request for ID " + gymId + " has been " + (newStatus == 1 ? "approved" : "rejected") + ".");
    }

    @Override
    public void approveAllGymRegistrationRequests() {
        System.out.println("All pending gym registration requests have been approved.");
    }
}
