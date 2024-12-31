package com.truxxkart.adminservice_v1.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Cart {
    private String cartId;
    private Long userId;
    private List<CartItem> cartItems;
    private double totalCartPrice ;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
