package com.flipkart.app;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Role;
import com.flipkart.bean.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FlipFitApplication {

	static Map<String, User> users = new HashMap<>();
	private static GymFlipFitCustomerMenu customerMenu = new GymFlipFitCustomerMenu();
	private static GymFlipFitAdminMenu adminMenu = new GymFlipFitAdminMenu();
	private static GymFlipFitGymOwnerMenu gymOwnerMenu = new GymFlipFitGymOwnerMenu();

	static {
		User admin = new Admin();
		users.put(admin.getUsername(), admin);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Welcome to the FlipFit Application:");
			System.out.println("1. Login");
			System.out.println("2. Registration of the GYM Customer");
			System.out.println("3. Registration of the GYM Owner");
			System.out.println("4. Change Password");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1:
					login(scanner);
					break;
				case 2:
					register(scanner, Role.GYMCUSTOMER);
					break;
				case 3:
					gymOwnerMenu.registerGymOwner(scanner);
					break;
				case 4:
					changePassword(scanner);
					break;
				case 5:
					System.out.println("Exiting the application. Goodbye!");
					scanner.close();
					System.exit(0);
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void login(Scanner scanner) {
		System.out.print("Username: ");
		String username = scanner.nextLine();
		System.out.print("Password: ");
		String password = scanner.nextLine();
		System.out.print("Role: ");
		String roleStr = scanner.nextLine();

		Role role;
		try {
			role = Role.valueOf(roleStr.toUpperCase().replace(" ", "_"));
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid role. Please try again.");
			return;
		}

		User user = users.get(username);
		if (user != null && user.getPassword().equals(password) && user.getRole() == role) {
			switch (role) {
				case GYMCUSTOMER:
					customerMenu.displayMenu(user, scanner);
					break;
				case GYMOWNER:
					gymOwnerMenu.displayMenu(user, scanner);
					break;
				case ADMIN:
					adminMenu.displayMenu(user, scanner);
					break;
				default:
					System.out.println("Invalid role. Please try again.");
			}
		} else {
			System.out.println("Invalid login credentials. Please try again.");
		}
	}

	private static void register(Scanner scanner, Role role) {
		System.out.print("Enter username: ");
		String username = scanner.nextLine();
		System.out.print("Enter password: ");
		String password = scanner.nextLine();

		if (!users.containsKey(username)) {
			users.put(username, new User(username, password, role));
			System.out.println(role.toString().replace("_", " ") + " registration successful.");
		} else {
			System.out.println("Username already exists. Please try a different username.");
		}
	}

	private static void changePassword(Scanner scanner) {
		System.out.print("Enter username: ");
		String username = scanner.nextLine();
		System.out.print("Enter old password: ");
		String oldPassword = scanner.nextLine();
		System.out.print("Enter new password: ");
		String newPassword = scanner.nextLine();

		User user = users.get(username);
		if (user != null && user.getPassword().equals(oldPassword)) {
			user.setPassword(newPassword);
			System.out.println("Password changed successfully.");
		} else {
			System.out.println("Invalid username or old password. Please try again.");
		}
	}
}
