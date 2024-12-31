package com.truxxkart.adminservice_v1.dto;

import lombok.Data;

@Data
public class CartItemDto {

    private Long productId; // Unique identifier for the product
    private int quantity;     // Quantity of the product
    private double price;     // Price per unit of the product
    private double discount;
    private double totalPrice;
}
