package com.flipkart.business.interfaces;

import com.flipkart.bean.GymCenter;

import java.util.List;

public interface gymCenterInterface {
    void addGymCenter(GymCenter gymCenter);
    List<GymCenter> getAllGymCenters();
}
