package com.flipkart.business.interfaces;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.List;

public interface adminInterface {
    List<GymOwner> getPendingGymOwnerApprovals();
    void handleGymOwnerRequest(int gymOwnerId, int newStatus);
    void approveAllGymOwners();
    List<GymCenter> getPendingGymRegistrationRequests();
    void handleGymRegistrationRequest(int gymId, int newStatus);
    void approveAllGymRegistrationRequests();
}


