package com.testcraftsmanship.resourcesmanagement.resources.items;

import java.util.Objects;

public class CognitoUser {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;

    public CognitoUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = firstName.toLowerCase() + "." + lastName.toLowerCase();
        //logic for setting other fields
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CognitoUser that = (CognitoUser) o;
        return Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
