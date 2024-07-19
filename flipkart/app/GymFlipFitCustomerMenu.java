package com.flipkart.app;

import com.flipkart.bean.User;
import com.flipkart.business.interfaces.gymCustomerInterface;

import java.util.Scanner;

public class GymFlipFitCustomerMenu {
    private gymCustomerInterface gymCustomerServ;

    public GymFlipFitCustomerMenu(gymCustomerInterface gymCustomerServ) {
        this.gymCustomerServ = gymCustomerServ;
    }

    public void displayMenu(User user, Scanner in) {
        int menuOption = 1;
        do {
            System.out.println("\n\n ------ Customer Menu Options ------ ");
            System.out.println("1. View available gyms");
            System.out.println("2. Book a slot");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View my bookings");
            System.out.println("5. View Profile");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            menuOption = in.nextInt();
            in.nextLine(); // Consume newline

            switch (menuOption) {
                case 1:
                    // Ensure gymCustomerService is initialized
                    if (gymCustomerServ != null) {
                        gymCustomerServ.displayAvailableGyms();
                    } else {
                        System.out.println("Gym service is not initialized!");
                    }
                    break;
                case 2:
                    if (gymCustomerServ != null) {
                        gymCustomerServ.bookSlot();
                    } else {
                        System.out.println("Gym service is not initialized!");
                    }
                    break;
                case 3:
                    if (gymCustomerServ != null) {
                        gymCustomerServ.cancelBooking();
                    } else {
                        System.out.println("Gym service is not initialized!");
                    }
                    break;
                case 4:
                    if (gymCustomerServ != null) {
                        gymCustomerServ.displayBookings();
                    } else {
                        System.out.println("Gym service is not initialized!");
                    }
                    break;
                case 5:
                    if (gymCustomerServ != null) {
                        gymCustomerServ.displayProfile(user);
                    } else {
                        System.out.println("Gym service is not initialized!");
                    }
                    break;
                case 6:
                    System.out.println("You have exited the customer menu");
                    break;
                default:
                    System.out.println("You have selected an invalid option, please try again!!");
                    break;
            }
        } while (menuOption != 6);
    }
}