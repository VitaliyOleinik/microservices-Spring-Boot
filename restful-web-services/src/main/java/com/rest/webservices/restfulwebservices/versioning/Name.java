package com.rest.webservices.restfulwebservices.versioning;

public class Name {
    private String firstName;
    private String secondName;

    public Name(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Name() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
