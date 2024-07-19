/*package com.flipkart.app;

import com.flipkart.bean.*;
import com.flipkart.business.interfaces.gymOwnerInterface;
import com.flipkart.business.interfaces.timeSlotInterface;
import com.flipkart.business.services.gymOwnerService;
import com.flipkart.business.services.timeSlotService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class GymFlipFitGymOwnerMenu {

    private gymOwnerInterface gymOwnerServ = new gymOwnerService();
    private timeSlotInterface timeSlotServ = new timeSlotService();

    public void displayMenu(User user, Scanner in) {
        int menuOption = 1;
        do {
            System.out.println("\n\n ------ Gym Owner Menu Options ------ ");
            System.out.println("1. Request to approve gym Centre");
            System.out.println("2. View Registered Gyms ");
            System.out.println("3. Register Time Slots ");
            System.out.println("4. Request to approve profile");
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
                    registerTimeSlots(user, in);
                    break;
                case 4:
                    sendProfileForApproval(in);
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
        GymCenter gymCenter = new GymCenter();
        System.out.print("Enter gym name: ");
        gymCenter.setGymName(scanner.nextLine());
        System.out.print("Enter location: ");
        gymCenter.setLocation(scanner.nextLine());
        System.out.print("Enter number of seats: ");
        gymCenter.setNoOfSeats(scanner.nextInt());
        scanner.nextLine();
        gymCenter.setGymOwnerID(user.getUsername());
        gymOwnerServ.addNewGym(gymCenter);
    }

    private void viewRegisteredGyms() {
        List<GymCenter> gymCenterList = gymOwnerServ.viewRegisteredGyms();
        System.out.println("GymID\tName\tLocation\tNo.of available seats");
        System.out.println("-----------------------------------------------------------");
        for (GymCenter gymCenter : gymCenterList) {
            System.out.println(gymCenter.getGymID() + "\t" + gymCenter.getGymName() + "\t" + gymCenter.getLocation() + "\t\t" + gymCenter.getNoOfSeats());
        }
    }

    private void registerTimeSlots(User user, Scanner scanner) {
        TimeSlot timeSlot = new TimeSlot();
        System.out.print("Enter slot ID: ");
        timeSlot.setSlotID(scanner.nextInt());
        System.out.print("Enter slot hour: ");
        timeSlot.setSlotHour(scanner.nextInt());
        System.out.print("Enter gym ID: ");
        timeSlot.setGymID(scanner.nextInt());
        System.out.print("Enter available seats: ");
        timeSlot.setAvailableSeats(scanner.nextInt());
        scanner.nextLine(); // Consume newline
        System.out.print("Enter day (YYYY-MM-DD): ");
        timeSlot.setDay(LocalDate.parse(scanner.nextLine()));
        timeSlotServ.createTimeSlot(timeSlot);
    }

    private void sendProfileForApproval(Scanner scanner) {
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
        gymOwnerServ.registerGymOwner(gymOwner);

        User user = new User(username, password, Role.GYMOWNER);
        FlipFitApplication.users.put(username, user);
        System.out.println("Profile sent for approval.");
    }

    private int generateUserID() {
        return gymOwnerServ.viewRegisteredGyms().size() + 1;
    }
}*/

package com.flipkart.app;

import com.flipkart.bean.*;
import com.flipkart.business.interfaces.gymCenterInterface;
import com.flipkart.business.interfaces.gymOwnerInterface;
import com.flipkart.business.interfaces.timeSlotInterface;
import com.flipkart.business.services.gymCenterService;
import com.flipkart.business.services.gymOwnerService;
import com.flipkart.business.services.timeSlotService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class GymFlipFitGymOwnerMenu {

    private gymOwnerInterface gymOwnerServ = new gymOwnerService();
    private timeSlotInterface timeSlotServ = new timeSlotService();
    private gymCenterInterface gymCenterServ = new gymCenterService();

    public void displayMenu(User user, Scanner in) {
        int menuOption = 1;
        do {
            System.out.println("\n\n ------ Gym Owner Menu Options ------ ");
            System.out.println("1. Add a new gym Centre");
            System.out.println("2. View Registered Gyms ");
            System.out.println("3. Register Time Slots ");
            System.out.println("4. Send Profile for Approval");
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
                    registerTimeSlots(user, in);
                    break;
                case 4:
                    sendProfileForApproval(in);
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
        GymCenter gymCenter = new GymCenter();
        System.out.print("Enter gym name: ");
        gymCenter.setGymName(scanner.nextLine());
        System.out.print("Enter location: ");
        gymCenter.setLocation(scanner.nextLine());
        System.out.print("Enter number of seats: ");
        gymCenter.setNoOfSeats(scanner.nextInt());
        scanner.nextLine();
        gymCenter.setGymOwnerID(user.getUsername());
        gymCenterServ.addGymCenter(gymCenter);
    }

    private void viewRegisteredGyms() {
        List<GymCenter> gymList = gymCenterServ.getAllGymCenters();
        System.out.println("GymID\tName\tLocation\tNo.of available seats");
        System.out.println("-----------------------------------------------------------");
        for (GymCenter gym : gymList) {
            System.out.println(gym.getGymID() + "\t" + gym.getGymName() + "\t" + gym.getLocation() + "\t\t" + gym.getNoOfSeats());
        }
    }

    private void registerTimeSlots(User user, Scanner scanner) {
        TimeSlot timeSlot = new TimeSlot();
        System.out.print("Enter slot ID: ");
        timeSlot.setSlotID(scanner.nextInt());
        System.out.print("Enter slot hour: ");
        timeSlot.setSlotHour(scanner.nextInt());
        System.out.print("Enter gym ID: ");
        timeSlot.setGymID(scanner.nextInt());
        System.out.print("Enter available seats: ");
        timeSlot.setAvailableSeats(scanner.nextInt());
        scanner.nextLine(); // Consume newline
        System.out.print("Enter day (YYYY-MM-DD): ");
        timeSlot.setDay(LocalDate.parse(scanner.nextLine()));
        timeSlotServ.createTimeSlot(timeSlot);
    }

    private void sendProfileForApproval(Scanner scanner) {
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
        gymOwnerServ.registerGymOwner(gymOwner);

        User user = new User(username, password, Role.GYMOWNER);
        FlipFitApplication.users.put(username, user);
        System.out.println("Profile sent for approval.");
    }

    private int generateUserID() {
        return gymOwnerServ.viewRegisteredGyms().size() + 1;
    }
}

