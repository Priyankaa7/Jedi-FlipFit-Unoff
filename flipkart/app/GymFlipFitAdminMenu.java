package com.flipkart.app;

import java.util.*;
import com.flipkart.bean.User;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.interfaces.adminInterface;
import com.flipkart.business.services.adminService;

public class GymFlipFitAdminMenu {

    private adminInterface adminServ = new adminService();

    public void displayMenu(User user, Scanner in) {
        int menuOption = 1;
        List<GymOwner> gymOwnerList;
        List<GymCenter> gymCenterList;
        do {
            System.out.println("\n\n --------------- Admin Menu Options --------------- ");
            System.out.println("Gym Owner Options:");
            System.out.println("\t1. View Pending Registration Request");
            System.out.println("\t2. Approve Registration");
            System.out.println("\t3. Approve ALL Pending Registration Requests");
            System.out.println("Gym Options:");
            System.out.println("\t4. View Pending Gym Registration");
            System.out.println("\t5. Approve Gym Registration");
            System.out.println("\t6. Approve ALL Gym Registration Requests");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");
            menuOption = in.nextInt();
            in.nextLine();

            switch (menuOption) {
                case 1:
                    gymOwnerList = adminServ.getPendingGymOwnerApprovals();
                    System.out.println("UserID\tUsername\tName\tAadhar Card #\tGSTIN#\t\t\tPAN Card\tAddress\t\tPincode");
                    System.out.println("---------------------------------------------------------------------------------------------------");
                    gymOwnerList.forEach(gymOwner -> System.out.println(gymOwner.getUserID() + "\t" + gymOwner.getUserName() + "\t\t"
                            + gymOwner.getName() + "\t" + gymOwner.getAadharCard() + "\t" + gymOwner.getGstIN()
                            + "\t\t" + gymOwner.getPanCard() + "\t" + gymOwner.getAddress()
                            + "\t" + gymOwner.getPINCode()));
                    break;
                case 2:
                    System.out.println("Enter gym owner user id");
                    int gymOwnerId = in.nextInt();
                    System.out.println("1. Approve\n2. Reject\n");
                    int newStatus = in.nextInt();
                    adminServ.handleGymOwnerRequest(gymOwnerId, newStatus);
                    break;
                case 3:
                    adminServ.approveAllGymOwners();
                    break;
                case 4:
                    gymCenterList = adminServ.getPendingGymRegistrationRequests();
                    System.out.println("GymID\tName\tLocation\t# of seats");
                    System.out.println("-----------------------------------------------------------");
                    gymCenterList.forEach(gym -> System.out.println(gym.getGymID() + "\t" + gym.getGymName() + "\t" + gym.getLocation() + "\t\t" + gym.getNoOfSeats()));
                    break;
                case 5:
                    System.out.println("Enter gym id");
                    int gymId = in.nextInt();
                    System.out.println("1. Approve\n2. Reject\n");
                    newStatus = in.nextInt();
                    adminServ.handleGymRegistrationRequest(gymId, newStatus);
                    break;
                case 6:
                    adminServ.approveAllGymRegistrationRequests();
                    break;
                case 7:
                    System.out.println("Exiting Admin Menu..");
                    break;
                default:
                    System.out.println("You have selected invalid option please try again!!");
                    break;
            }
        } while (menuOption != 7);
    }
}
