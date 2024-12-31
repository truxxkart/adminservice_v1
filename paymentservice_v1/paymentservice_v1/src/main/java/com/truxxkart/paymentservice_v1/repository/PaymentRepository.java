package com.truxxkart.paymentservice_v1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truxxkart.paymentservice_v1.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	Optional<Payment> findByOrderId(Long orderId);
	Optional<List<Payment>> findByUserId(Long userId);

}
