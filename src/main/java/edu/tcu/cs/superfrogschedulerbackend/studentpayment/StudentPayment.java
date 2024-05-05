package edu.tcu.cs.superfrogschedulerbackend.studentpayment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.Period;
import java.util.Date;

import static jakarta.persistence.GenerationType.AUTO;


@Entity
public class StudentPayment implements Serializable {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer studentPaymentFormId; //unique ids for the forms
    private String studentFirstName;
    private String studentLastName;
    private Integer amount; //final amount to pay student and charge customer
    private Date studentPaymentPeriod; //from student times or what?


    public StudentPayment() {

    }

    public StudentPayment(Integer studentPaymentId, String studentFirstName, String studentLastName, Integer amount, Date studentPaymentPeriod, boolean approved) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.amount = amount;
        this.studentPaymentPeriod = studentPaymentPeriod;
    }

    public Integer getStudentPaymentFormId() {
        return studentPaymentFormId;
    }

    public void setStudentPaymentFormId(Integer studentPaymentFormId) {
        this.studentPaymentFormId = studentPaymentFormId;
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

    public Date getStudentPaymentPeriod() {
        return studentPaymentPeriod;
    }

    public void setStudentPaymentPeriod(Date studentPaymentPeriod) {
        this.studentPaymentPeriod = studentPaymentPeriod;
    }
}