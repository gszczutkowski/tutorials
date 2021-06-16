package com.testcraftsmanship.clientsidecert.authentication;

public class User {
    private UserType userType;
    private String userName;
    private String userPassword;

    public User(UserType userType, String userName, String userPassword) {
        this.userType = userType;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
}