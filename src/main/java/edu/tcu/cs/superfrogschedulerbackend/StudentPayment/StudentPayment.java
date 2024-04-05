package edu.tcu.cs.superfrogschedulerbackend.StudentPayment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;


@Entity
public class StudentPayment implements Serializable {

    private String studentName;
    private String taxId;
    private String ssn;
    private String address;
    private Integer amount;
    private boolean approved;
    @Id
    private String paymentId; //this may not be needed since it's for the customer payment
    private String authorizedCodes;
    private String approverName; //i dont think this is needed, but inputting just in case

    public StudentPayment() {

    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getAuthorizedCodes() {
        return authorizedCodes;
    }

    public void setAuthorizedCodes(String authorizedCodes) {
        this.authorizedCodes = authorizedCodes;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }
}
