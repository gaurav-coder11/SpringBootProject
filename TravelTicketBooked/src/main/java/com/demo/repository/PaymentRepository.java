package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Payments;

@Repository
public interface PaymentRepository extends JpaRepository<Payments, Long> {
    Payments findByPayerName(String payerName);
}
