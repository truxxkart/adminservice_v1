package com.truxxkart.adminservice_v1.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderItem {
    private String id;
    private Orders order;
    private Long productId;
    private int quantity;
    private double price;
    private double totalPrice;
    private double totalDiscountedPrice;         // quantity * price
    private String status; // PENDING, CONFIRMED, SHIPPED, DELIVERED, CANCELLED
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
