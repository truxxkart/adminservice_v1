package com.truxxkart.adminservice_v1.dto;

import lombok.Data;

import java.util.List;

@Data
public class Orders {

    private String id;
    private Long userId; // The user placing the order
    private List<OrderItem> orderItems;
    private double totalOrderAmount;
    private String paymentMode;
    private String paymentId; // ID of the payment transaction (if integrated)

}
