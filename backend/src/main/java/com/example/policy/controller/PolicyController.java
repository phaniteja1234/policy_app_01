package com.example.policy.controller;

import com.example.policy.model.Policy;
import com.example.policy.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
    @Autowired
    private PolicyService policyService;

    @PutMapping("/update-expiration")
    public Policy updateExpiration(@RequestParam String policyNumber,
                                   @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate expirationDate) {
        return policyService.updateExpiration(policyNumber, expirationDate);
    }

    @PutMapping("/update-payment-status")
    public Policy updatePaymentStatus(@RequestParam String policyNumber,
                                      @RequestParam String paymentStatus) {
        return policyService.updatePaymentStatus(policyNumber, paymentStatus);
    }
}
