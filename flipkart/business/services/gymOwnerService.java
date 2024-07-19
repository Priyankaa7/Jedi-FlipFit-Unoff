package com.flipkart.business.services;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.interfaces.gymOwnerInterface;

import java.util.ArrayList;
import java.util.List;

public class gymOwnerService implements gymOwnerInterface {
    private List<GymOwner> gymOwners = new ArrayList<>();

    @Override
    public void registerGymOwner(GymOwner gymOwner) {
        gymOwners.add(gymOwner);
        System.out.println("GYM Owner registration successful.");
    }

    @Override
    public void addNewGym(GymCenter gymCenter) {
        GymCenter.addGym(gymCenter);
        System.out.println("New gym center added successfully.");
    }

    @Override
    public List<GymCenter> viewRegisteredGyms() {
        return GymCenter.getGymList();
    }
}
