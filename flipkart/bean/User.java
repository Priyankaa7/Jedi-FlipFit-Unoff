package com.flipkart.bean;

public class User {
	private String username;
	private String password;
	private Role role;
	private String userID;

	public User(String username, String password, Role role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername() { this.username = username; }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public Role getRole() {
		return role;
	}

	public void setRole() { this.role = role; }
}
