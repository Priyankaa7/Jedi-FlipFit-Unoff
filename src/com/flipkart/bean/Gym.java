package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

public class Gym {
	private static int idCounter = 1;
	private int gymID;
	private String gymName;
	private String location;
	private int noOfSeats;
	private String gymOwnerID;

	private static List<Gym> gymList = new ArrayList<>();

	static {
		Gym gym1 = new Gym();
		gym1.setGymName("Be Fit");
		gym1.setLocation("HSR Layout");
		gym1.setNoOfSeats(30);
		gym1.setGymOwnerID("1");
		gymList.add(gym1);

		Gym gym2 = new Gym();
		gym2.setGymName("Cult Fit");
		gym2.setLocation("Begur");
		gym2.setNoOfSeats(45);
		gym2.setGymOwnerID("2");
		gymList.add(gym2);

		Gym gym3 = new Gym();
		gym3.setGymName("ABC Gym");
		gym3.setLocation("HSR Layout");
		gym3.setNoOfSeats(50);
		gym3.setGymOwnerID("3");
		gymList.add(gym3);
	}

	public Gym() {
		this.gymID = idCounter++;
	}

	public static List<Gym> getGymList() {
		return gymList;
	}

	public static void addGym(Gym gym) {
		gymList.add(gym);
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
