package com.truxxkart.adminservice_v1.feignclient.userService;

import com.truxxkart.adminservice_v1.dto.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "userserviceOrder",url = "http://localhost:8010/orders")
public interface OrderFeign {

    @GetMapping("/userId/{userId}")
    public Orders findOrdersOfUser(@PathVariable Long userId);

    @PostMapping("/checkout")
    public Orders createOrder(@RequestParam Long userId , @RequestParam String paymentMode);
}
