package com.truxxkart.deliveryservice_v1.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.truxxkart.deliveryservice_v1.entity.OrderItemDto;

@FeignClient(name = "userservice" ,url = "http://localhost:7000")
public interface OrderFeignInterface {
	
	@GetMapping("/order-items/status/today")
	public ResponseEntity<List<OrderItemDto>> getOrderItemsByStatusAndDate(@RequestParam String status,@RequestParam int day,
			@RequestParam int month,@RequestParam int year);

}
