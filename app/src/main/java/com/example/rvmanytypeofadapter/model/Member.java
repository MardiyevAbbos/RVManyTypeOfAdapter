package com.example.rvmanytypeofadapter.model;

public class Member {
    public String firstName;
    public String lastName;
    public boolean available;

    public Member(String firstName, String lastName, boolean available) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.available = available;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
