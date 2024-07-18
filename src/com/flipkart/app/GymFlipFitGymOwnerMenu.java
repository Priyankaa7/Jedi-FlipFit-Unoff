package com.flipkart.app;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Role;
import com.flipkart.bean.User;
import com.flipkart.bean.Gym;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GymFlipFitGymOwnerMenu {
    private List<GymOwner> gymOwners = new ArrayList<>();

    public void registerGymOwner(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Aadhar Card number: ");
        String aadharCard = scanner.nextLine();
        System.out.print("Enter GSTIN: ");
        String gstIN = scanner.nextLine();
        System.out.print("Enter PAN Card: ");
        String panCard = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter PIN Code: ");
        String pinCode = scanner.nextLine();

        GymOwner gymOwner = new GymOwner(generateUserID(), username, name, aadharCard, gstIN, panCard, address, pinCode);
        gymOwners.add(gymOwner);

        User user = new User(username, password, Role.GYMOWNER);
        FlipFitApplication.users.put(username, user);

        System.out.println("GYM Owner registration successful.");
    }

    public void displayMenu(User user, Scanner in) {
        int menuOption = 1;
        do {
            System.out.println("\n\n ------ Gym Owner Menu Options ------ ");
            System.out.println("1. Add a new gym Centre");
            System.out.println("2. View Registered Gyms ");
            System.out.println("3. Register Time Slots ");
            System.out.println("4. View Profile");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            menuOption = in.nextInt();
            in.nextLine();

            switch (menuOption) {
                case 1:
                    addNewGym(user, in);
                    break;
                case 2:
                    viewRegisteredGyms();
                    break;
                case 3:
                    // registerTimeSlots(user, in);
                    break;
                case 4:
                    // viewProfile(user);
                    break;
                case 5:
                    System.out.println("You have exited the gym owner menu.");
                    break;
                default:
                    System.out.println("You have selected an invalid option, please try again!!");
                    break;
            }
        } while (menuOption != 5);
    }

    private void addNewGym(User user, Scanner scanner) {
        Gym gym = new Gym();
        System.out.print("Enter gym name: ");
        gym.setGymName(scanner.nextLine());
        System.out.print("Enter location: ");
        gym.setLocation(scanner.nextLine());
        System.out.print("Enter number of seats: ");
        gym.setNoOfSeats(scanner.nextInt());
        scanner.nextLine();
        gym.setGymOwnerID(user.getUsername());
        Gym.addGym(gym);
        System.out.println("New gym center added successfully.");
    }

    private void viewRegisteredGyms() {
        List<Gym> gymList = Gym.getGymList();
        System.out.println("GymID\tName\tLocation\tNo.of available seats");
        System.out.println("-----------------------------------------------------------");
        for (Gym gym : gymList) {
            System.out.println(gym.getGymID() + "\t" + gym.getGymName() + "\t" + gym.getLocation() + "\t\t" + gym.getNoOfSeats());
        }
    }

    private int generateUserID() {
        return gymOwners.size() + 1;
    }
}
