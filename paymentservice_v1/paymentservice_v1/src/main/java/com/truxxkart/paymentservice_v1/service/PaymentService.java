package com.truxxkart.paymentservice_v1.service;

import java.util.List;

import com.truxxkart.paymentservice_v1.entity.Payment;

public interface PaymentService {

	public Payment createPayment(Payment payment);

	public Payment getPaymentByOrderId(Long orderId);
	
	public List<Payment> getAllPayments();

	public List<Payment> getPaymentByUserId(Long userId);

	public Payment getPaymentByPaymentId(Long paymentId);

	Payment updatePayment(Long paymentId, Payment updatedPayment);

	public void deletePayment(Long paymentId);

	public Payment markPaymentAsRefunded(Long paymentId);

}
