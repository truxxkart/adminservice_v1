package com.truxxkart.paymentservice_v1.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truxxkart.paymentservice_v1.entity.Payment;
import com.truxxkart.paymentservice_v1.exceptions.PaymentNotFoundException;
import com.truxxkart.paymentservice_v1.repository.PaymentRepository;
import com.truxxkart.paymentservice_v1.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
      @Autowired
      private PaymentRepository payRepo;
	@Override
	public Payment createPayment(Payment payment) {
		Payment createdPay=payRepo.save(payment);
		return createdPay;
	}

	@Override
	public Payment getPaymentByOrderId(Long orderId) {
		Optional<Payment> optPay =payRepo.findByOrderId(orderId);
		if(optPay.isPresent()) {
			return optPay.get();
		}
		return null;
	}

	@Override
	public List<Payment> getPaymentByUserId(Long userId) {
	Optional< List<Payment>> optPay =payRepo.findByUserId(userId);
		if(optPay.isPresent()) {
			return optPay.get();
		}
		return null;
	}

	@Override
	public Payment getPaymentByPaymentId(Long paymentId) {
		Optional<Payment> optPay =payRepo.findById(paymentId);
		if(optPay.isPresent()) {
			return optPay.get();
		}
		return null;
	}

	@Override
	public Payment updatePayment(Long paymentId, Payment updatedPayment) {
		  Payment existingPayment = payRepo.findById(paymentId)
		            .orElseThrow(() -> new PaymentNotFoundException("Payment not found with ID: " + paymentId));

		        // Update allowed fields only
		        existingPayment.setAmount(updatedPayment.getAmount());
		        existingPayment.setCurrency(updatedPayment.getCurrency());
		        existingPayment.setPaymentMethod(updatedPayment.getPaymentMethod());
		        existingPayment.setStatus(updatedPayment.getStatus());
		        existingPayment.setGateway(updatedPayment.getGateway());

		        return payRepo.save(existingPayment);
	}

	@Override
	public void deletePayment(Long paymentId) {
		payRepo.deleteById(paymentId);

	}



	@Override
	public Payment markPaymentAsRefunded(Long paymentId) {
		Optional<Payment> optPay =payRepo.findById(paymentId);
		if(optPay.isPresent()) {
			Payment pay= optPay.get();
			pay.setRefundStatus("REFUNDED");
			return payRepo.save(pay);
		}
		return null;
	}

	@Override
	public List<Payment> getAllPayments() {
		
		return payRepo.findAll();
	}

}
