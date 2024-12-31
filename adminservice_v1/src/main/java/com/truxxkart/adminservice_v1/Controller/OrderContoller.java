package com.truxxkart.adminservice_v1.Controller;

import com.truxxkart.adminservice_v1.dto.Orders;
import com.truxxkart.adminservice_v1.feignclient.userService.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderContoller {

    @Autowired
    OrderFeign orderFeign;

    @GetMapping("/userId/{userId}")
    public Orders findOrdersOfUser(@PathVariable Long userId) {
        return orderFeign.findOrdersOfUser(userId);
    }

    @PostMapping("/checkout")
    public Orders createOrder(@RequestParam Long userId , @RequestParam String paymentMode) {
        return orderFeign.createOrder(userId,paymentMode);
    }
}
