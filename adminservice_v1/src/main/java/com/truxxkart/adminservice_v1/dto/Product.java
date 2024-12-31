package com.truxxkart.adminservice_v1.dto;

import java.time.LocalDateTime;

public class Product {

    private Long id;
    private String name;
    private String description;
    private User seller;
    private Boolean isActive;
    private Double price;
    private Double rating;
    private Long saleCount;
    private Long monthSaleCount;
    private Long weekSaleCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
