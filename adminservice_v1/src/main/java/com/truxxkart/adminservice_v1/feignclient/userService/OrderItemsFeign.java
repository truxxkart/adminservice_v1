package com.truxxkart.adminservice_v1.feignclient.userService;

import com.truxxkart.adminservice_v1.dto.OrderItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "userserviceOrderItems",url = "http://localhost:8010/order-items")
public interface OrderItemsFeign {

    @GetMapping("/status/today")
    public ResponseEntity<List<OrderItem>> getOrderItemsByStatusAndDate(@RequestParam String status, @RequestParam int day,
                                                                        @RequestParam int month, @RequestParam int year);



}
