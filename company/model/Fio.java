package com.company.model;

import java.util.regex.Pattern;

public class Fio {
    private String firstName;
    private String lastName;
    private String fatherName;

    public void setFirstName(String firstName) {
        if (!Pattern.matches(".*[a-zA-Z]+.*", firstName)) {
            throw new IllegalArgumentException("\n\n" + firstName + " can not be a first name!\n\n");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (!Pattern.matches(".*[a-zA-Z]+.*", lastName)) {
            throw new IllegalArgumentException("\n\n" + lastName + " can not be a last name!\n\n");
        }
        this.lastName = lastName;
    }

    public void setFatherName(String fatherName) {
        if (!Pattern.matches(".*[a-zA-Z]+.*", fatherName)) {
            throw new IllegalArgumentException("\n\n" + fatherName + " can not be a father name!\n\n");
        }
        this.fatherName = fatherName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFatherName() {
        return fatherName;
    }
}