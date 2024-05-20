package com.example.policy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Policy {

    @Id
    private String policyNumber;
    private String policyHolderName;
    private String policyType;
    private String policyStatus;
    private LocalDate policyExpiryDate;
    private String policyPaymentStatus;

    private String policyId;

    // Getters and Setters
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public void setPolicyHolderName(String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }
    public String getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(String policyStatus) {
        this.policyStatus = policyStatus;
    }

    public LocalDate getPolicyExpiryDate() {
        return policyExpiryDate;
    }

    public void setPolicyExpiryDate(LocalDate policyExpiryDate) {
        this.policyExpiryDate = policyExpiryDate;
    }

    public String getPolicyPaymentStatus() {
        return policyPaymentStatus;
    }

    public void setPolicyPaymentStatus(String policyPaymentStatus) {
        this.policyPaymentStatus = policyPaymentStatus;
    }
}
