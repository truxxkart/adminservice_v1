package com.truxxkart.deliveryservice_v1.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class OrderItemDto {

  
    private String id;

    private Long productId;

    private int quantity;

    private double price;

    private double totalPrice; // quantity * price
    
   
    private double totalDiscountedPrice;
    private String status; // PENDING, CONFIRMED, SHIPPED, DELIVERED, CANCELLED
    
    private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	


}
