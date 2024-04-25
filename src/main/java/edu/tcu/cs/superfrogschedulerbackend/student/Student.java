package edu.tcu.cs.superfrogschedulerbackend.student;

import edu.tcu.cs.superfrogschedulerbackend.studenttimes.StudentTimes;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

@Entity
public class Student implements Serializable {
    @Id
    private String id;
    @OneToMany(mappedBy = "student")
    private List<StudentTimes> studentTimes;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String email;
    private boolean international;


    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<StudentTimes> getStudentTimes() {
        return this.studentTimes;
    }

    public void setStudentTimes(List<StudentTimes> studentTimes) {
        this.studentTimes = studentTimes;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isInternational() {
        return international;
    }

    public void setInternational(boolean international) {
        this.international = international;
    }


}
