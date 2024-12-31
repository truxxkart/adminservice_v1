package com.truxxkart.paymentservice_v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.truxxkart.paymentservice_v1.entity.Payment;
import com.truxxkart.paymentservice_v1.service.PaymentService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;

	@PostMapping
	public Payment createPayment(@RequestBody @Valid Payment payment) {
		return paymentService.createPayment(payment);
	}

	@PutMapping("/{id}")
	public Payment updatePayment(@PathVariable Long id, @RequestBody @Valid Payment payment) {
		return paymentService.updatePayment(id, payment);
	}

	@GetMapping("/payment/{id}")
	public Payment getPaymentById(@PathVariable Long id) {
		return paymentService.getPaymentByPaymentId(id);

	}
	
	@GetMapping("/user/{id}")
	public List<Payment> getPaymentByUserId(@PathVariable Long id) {
		return paymentService.getPaymentByUserId(id);

	}
	
	@GetMapping("/order/{id}")
	public Payment getPaymentByOrderId(@PathVariable Long id) {
		return paymentService.getPaymentByOrderId(id);

	}

	@GetMapping
	public List<Payment> getAllPayments() {
		return paymentService.getAllPayments();
	}

	@DeleteMapping("/{id}")
	public void deletePayment(@PathVariable Long id) {
		paymentService.deletePayment(id);
	}

	@PatchMapping("/{id}/refund")
	public Payment refundPayment(@PathVariable Long id) {
		return paymentService.markPaymentAsRefunded(id);
	}
}
