package com.example.policy.repo;

import com.example.policy.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
    Optional<Policy> findById(String id);

    Optional<Policy> findByPolicyNumber(String policyNumber);
}
