package com.testcraftsmanship.clientsidecert.authentication;

public enum UserType {
    ADMIN("/profiles/admin/."), CUSTOMER("/profiles/customer/.");

    private final String profilePath;

    UserType(String profilePath) {
        this.profilePath = profilePath;
    }

    public String getProfilePath() {
        return profilePath;
    }
}