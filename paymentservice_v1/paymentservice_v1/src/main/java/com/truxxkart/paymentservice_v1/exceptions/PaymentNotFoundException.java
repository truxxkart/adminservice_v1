package com.truxxkart.paymentservice_v1.exceptions;
public class PaymentNotFoundException extends RuntimeException {
    public PaymentNotFoundException(String message) {
        super(message);
    }
}
