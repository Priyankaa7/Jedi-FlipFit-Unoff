package com.flipkart.bean;

public class GymOwner {
    private int userID;
    private String userName;
    private String name;
    private String aadharCard;
    private String gstIN;
    private String panCard;
    private String address;
    private String pinCode;

    public GymOwner(int userID, String userName, String name, String aadharCard, String gstIN, String panCard, String address, String pinCode) {
        this.userID = userID;
        this.userName = userName;
        this.name = name;
        this.aadharCard = aadharCard;
        this.gstIN = gstIN;
        this.panCard = panCard;
        this.address = address;
        this.pinCode = pinCode;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public String getAadharCard() {
        return aadharCard;
    }

    public String getGstIN() {
        return gstIN;
    }

    public String getPanCard() {
        return panCard;
    }

    public String getAddress() {
        return address;
    }

    public String getPINCode() {
        return pinCode;
    }

    @Override
    public String toString() {
        return "GymOwner{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", aadharCard='" + aadharCard + '\'' +
                ", gstIN='" + gstIN + '\'' +
                ", panCard='" + panCard + '\'' +
                ", address='" + address + '\'' +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }
}
