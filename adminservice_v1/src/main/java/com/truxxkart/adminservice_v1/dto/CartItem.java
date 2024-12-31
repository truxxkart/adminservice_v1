package com.truxxkart.adminservice_v1.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CartItem {
    private String cartItemId;
    private Cart cart;
    private Long productId;
    private int quantity;
    private double price;
    private double discount;
    private double totalPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
