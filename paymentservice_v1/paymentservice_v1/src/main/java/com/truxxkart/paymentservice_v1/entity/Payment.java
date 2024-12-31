package com.truxxkart.paymentservice_v1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

import com.truxxkart.paymentservice_v1.enums.PaymentMethod;
import com.truxxkart.paymentservice_v1.enums.PaymentStatus;

@Data
@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;

	@NotNull
	private Long orderId;

	@NotNull
	private Long userId;

	@NotBlank(message = "Gateway name is required")
	@Size(max = 50, message = "Gateway name must not exceed 50 characters")
	private String gateway;

	@NotBlank(message = "Transaction ID is required")
	@Size(max = 255, message = "Transaction ID must not exceed 255 characters")
	private String transactionId;

	@NotNull(message = "Amount is required")

	private Double amount;

	@NotBlank(message = "Currency is required")
	@Size(max = 10, message = "Currency code must not exceed 10 characters")
	private String currency;

	@NotNull
	@Enumerated(EnumType.STRING)
	private PaymentStatus status; // successful ,pending,cancelled ,failed

	@NotNull
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod; // card, upi ,cod

	private String refundStatus;

	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	/**
	 * Automatically set `createdAt` before persisting the entity.
	 */
	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
	}

	/**
	 * Automatically update `updatedAt` before updating the entity.
	 */
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

	// Getters and Setters

}
