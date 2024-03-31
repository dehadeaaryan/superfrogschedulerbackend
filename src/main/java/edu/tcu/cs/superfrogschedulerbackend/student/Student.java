package edu.tcu.cs.superfrogschedulerbackend.student;

import java.io.Serializable;

public class Student implements Serializable {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String email;
    private boolean international;

    private String taxID;

    private String ssn;
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName){
        
    }
}
