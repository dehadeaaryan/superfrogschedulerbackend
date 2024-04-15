package edu.tcu.cs.superfrogschedulerbackend.studentpayment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;


@Entity
public class StudentPayment implements Serializable {
    @Id
    private Integer id;
    private String studentName;
    private String address;
    private Integer amount;
    private boolean approved; //change the status on the calendar/student object so its set to Submitted to Payroll

    public StudentPayment() {

    }

    public String getStudentName() {
        return studentName;
    }

    public String getAddress() {
        return address;
    }

    //has to be calculated according to the business rules. create a method to do so?
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


}
