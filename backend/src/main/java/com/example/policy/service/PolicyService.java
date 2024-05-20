package com.example.policy.service;

import com.example.policy.model.Policy;
import com.example.policy.repo.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    public Policy updateExpiration(String policyNumber, LocalDate expirationDate) {
        Optional<Policy> policyOptional = policyRepository.findByPolicyNumber(policyNumber);
        if (policyOptional.isEmpty()) {
            throw new RuntimeException("Policy with ID " + policyNumber + " not found");
        }

        Policy policy = policyOptional.get();
        policy.setPolicyExpiryDate(expirationDate);

        if (expirationDate.isBefore(LocalDate.now())) {
            policy.setPolicyStatus("inactive");
        } else {
            policy.setPolicyStatus("active");
        }

        return policyRepository.save(policy);
    }

    public Policy updatePaymentStatus(String policyNumber, String paymentStatus) {
        Optional<Policy> policyOptional = policyRepository.findByPolicyNumber(policyNumber);
        if (policyOptional.isEmpty()) {
            throw new RuntimeException("Policy with ID " + policyNumber + " not found");
        }

        Policy policy = policyOptional.get();
        policy.setPolicyPaymentStatus(paymentStatus);

        if ("unpaid".equals(paymentStatus)) {
            policy.setPolicyStatus("inactive");
            policy.setPolicyExpiryDate(LocalDate.now());
        } else {
            policy.setPolicyStatus("active");
        }

        return policyRepository.save(policy);
    }
}
