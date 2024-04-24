package edu.tcu.cs.superfrogschedulerbackend.studentpayment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.Period;


@Entity
public class StudentPayment implements Serializable {
    @Id
    //@GeneratedValue(GenerationType.AUTO) //correct this error later
    private Integer studentPaymentId; //is this needed? forms must be identified elsewhere?
    private String studentFirstName;
    private String studentLastName;
    private Integer amount; //amount to pay
    private Period studentPaymentPeriod;
    private boolean approved; //change the status on the calendar/student object so its set to Submitted to Payroll. Is this the best place for this?

    public StudentPayment() {

    }

    public StudentPayment(Integer studentPaymentId, String studentFirstName, String studentLastName, Integer amount, Period studentPaymentPeriod, boolean approved) {
        this.studentPaymentId = studentPaymentId;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.amount = amount;
        this.studentPaymentPeriod = studentPaymentPeriod;
        this.approved = approved;
    }

    public Integer getStudentPaymentId() {
        return studentPaymentId;
    }

    public void setStudentPaymentId(Integer studentPaymentId) {
        this.studentPaymentId = studentPaymentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Period getStudentPaymentPeriod() {
        return studentPaymentPeriod;
    }

    public void setStudentPaymentPeriod(Period studentPaymentPeriod) {
        this.studentPaymentPeriod = studentPaymentPeriod;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
