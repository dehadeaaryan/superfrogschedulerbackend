package edu.tcu.cs.superfrogschedulerbackend.request;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Request implements Serializable {
    @Id
    private String id;
    private String customerFirstName;
    private String customerLastName;
    private String phoneNumber;
    private String eventType;
    private String eventTitle;
    private String organizationName;
    private String eventAddress;
    private Boolean onCampus;
    private String specialInstructions;
    private String expensesAndBenefitsToSpiritTeam;
    private String otherOutsideOrganizations;
    private String eventDescription;
    private String status;
    private Boolean approved;
    private Boolean paid;
    private Double amount;

    public Request() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public Boolean getOnCampus() {
        return onCampus;
    }

    public void setOnCampus(Boolean onCampus) {
        this.onCampus = onCampus;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public String getExpensesAndBenefitsToSpiritTeam() {
        return expensesAndBenefitsToSpiritTeam;
    }

    public void setExpensesAndBenefitsToSpiritTeam(String expensesAndBenefitsToSpiritTeam) {
        this.expensesAndBenefitsToSpiritTeam = expensesAndBenefitsToSpiritTeam;
    }

    public String getOtherOutsideOrganizations() {
        return otherOutsideOrganizations;
    }

    public void setOtherOutsideOrganizations(String otherOutsideOrganizations) {
        this.otherOutsideOrganizations = otherOutsideOrganizations;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
