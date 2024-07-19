package com.flipkart.business.services;

import com.flipkart.bean.GymCenter;
import com.flipkart.business.interfaces.gymCenterInterface;

import java.util.ArrayList;
import java.util.List;

public class gymCenterService implements gymCenterInterface {

    private List<GymCenter> gymCenterList = new ArrayList<>();

    public gymCenterService() {
        // Initialize with some gym centers
        GymCenter gymCenter1 = new GymCenter();
        gymCenter1.setGymName("Be Fit");
        gymCenter1.setLocation("HSR Layout");
        gymCenter1.setNoOfSeats(30);
        gymCenter1.setGymOwnerID("1");
        gymCenterList.add(gymCenter1);

        GymCenter gymCenter2 = new GymCenter();
        gymCenter2.setGymName("Cult Fit");
        gymCenter2.setLocation("Begur");
        gymCenter2.setNoOfSeats(45);
        gymCenter2.setGymOwnerID("2");
        gymCenterList.add(gymCenter2);

        GymCenter gymCenter3 = new GymCenter();
        gymCenter3.setGymName("ABC Gym");
        gymCenter3.setLocation("HSR Layout");
        gymCenter3.setNoOfSeats(50);
        gymCenter3.setGymOwnerID("3");
        gymCenterList.add(gymCenter3);
    }

    @Override
    public void addGymCenter(GymCenter gymCenter) {
        gymCenterList.add(gymCenter);
    }

    @Override
    public List<GymCenter> getAllGymCenters() {
        return gymCenterList;
    }
}
