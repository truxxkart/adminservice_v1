package com.truxxkart.deliveryservice_v1.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.truxxkart.deliveryservice_v1.enums.DeliveryEnums;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@Data
@Entity
public class Deliveries {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private Long deliveryAgentId;
	private Long userId;
	private String orderId;
	@Column(unique = true)
	private String orderItemId;
	@Enumerated(EnumType.STRING)
	private DeliveryEnums priority =DeliveryEnums.LOW;
	@OneToOne
	private Address sourceAddress;
	@OneToOne
	private Address destinationAddress;
	private boolean isAccepted=false;
	private String deliveryNote;
	private LocalDateTime pickupTime;
	private LocalDateTime deliveredTime;
	
	
	private Boolean isActive = true;
	@Enumerated(EnumType.STRING)
    private DeliveryEnums status =DeliveryEnums.PENDING;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

}
