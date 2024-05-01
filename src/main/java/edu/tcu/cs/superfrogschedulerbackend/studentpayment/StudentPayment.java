package edu.tcu.cs.superfrogschedulerbackend.studentpayment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.Period;

import static jakarta.persistence.GenerationType.AUTO;


@Entity
public class StudentPayment implements Serializable {
    @Id
    @GeneratedValue(AUTO)
    private Integer studentPaymentFormId; //unique ids for the forms
    private String studentFirstName;
    private String studentLastName;
    private Integer amount; //final amount to pay student and charge customer
    private Period studentPaymentPeriod; //from student times or what?
    //need the student ID so I can uniquely identify them. From Student

    public StudentPayment() {

    }

    public StudentPayment(Integer studentPaymentId, String studentFirstName, String studentLastName, Integer amount, Period studentPaymentPeriod, boolean approved) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.amount = amount;
        this.studentPaymentPeriod = studentPaymentPeriod;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public Integer getAmount() {
        return amount;
    }

    public Period getStudentPaymentPeriod() {
        return studentPaymentPeriod;
    }

}
