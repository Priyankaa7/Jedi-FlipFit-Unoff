package com.flipkart.business.interfaces;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.List;

public interface gymOwnerInterface {
    void registerGymOwner(GymOwner gymOwner);
    void addNewGym(GymCenter gymCenter);
    List<GymCenter> viewRegisteredGyms();
}


