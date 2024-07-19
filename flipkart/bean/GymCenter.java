package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

public class GymCenter {
	private static int idCounter = 1;
	private int gymID;
	private String gymName;
	private String location;
	private int noOfSeats;
	private String gymOwnerID;

	private static List<GymCenter> gymCenterList = new ArrayList<>();

	static {
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

	public GymCenter() {
		this.gymID = idCounter++;
	}

	public static List<GymCenter> getGymList() {
		return gymCenterList;
	}

	public static void addGym(GymCenter gymCenter) {
		gymCenterList.add(gymCenter);
	}

	public int getGymID() {
		return gymID;
	}

	public String getGymName() {
		return gymName;
	}

	public void setGymName(String gymName) {
		this.gymName = gymName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getGymOwnerID() {
		return gymOwnerID;
	}

	public void setGymOwnerID(String gymOwnerID) {
		this.gymOwnerID = gymOwnerID;
	}
}
