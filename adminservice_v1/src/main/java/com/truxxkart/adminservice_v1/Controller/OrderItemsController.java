package com.truxxkart.adminservice_v1.Controller;


import com.truxxkart.adminservice_v1.dto.OrderItem;
import com.truxxkart.adminservice_v1.feignclient.userService.OrderItemsFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderItemsController {

    @Autowired
    private OrderItemsFeign orderItemsFeign;
    @GetMapping("/status/today")
    public ResponseEntity<List<OrderItem>> getOrderItemsByStatusAndDate(@RequestParam String status, @RequestParam int day,
                                                                        @RequestParam int month, @RequestParam int year){

        ResponseEntity<List<OrderItem>> orderItemStatus =  orderItemsFeign.getOrderItemsByStatusAndDate(status, day, month, year);
        return orderItemStatus;
    }
}
