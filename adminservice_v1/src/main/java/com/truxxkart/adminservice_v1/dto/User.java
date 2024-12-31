package com.truxxkart.adminservice_v1.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User
{

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String passwordHash;
    private String gstin;
    private int deliveryCountOfDay;
    private int deliveryInHand;
    private boolean isAvailable;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
