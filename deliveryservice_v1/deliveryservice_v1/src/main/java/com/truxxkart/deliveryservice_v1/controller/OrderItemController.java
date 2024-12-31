package com.truxxkart.deliveryservice_v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.truxxkart.deliveryservice_v1.entity.OrderItemDto;
import com.truxxkart.deliveryservice_v1.feignclient.OrderFeignInterface;


@RestController
@RequestMapping("/order-items")
public class OrderItemController {
	
	@Autowired
	private OrderFeignInterface orderFI;
	
	@GetMapping("/status/today")
	public ResponseEntity<List<OrderItemDto>> getOrderItemsByStatusAndDate(@RequestParam String status,@RequestParam int day,
			@RequestParam int month,@RequestParam int year){
              List<OrderItemDto> orderItemList =orderFI.getOrderItemsByStatusAndDate(status, day, month, year).getBody();
              if(orderItemList!=null) {
            	  return ResponseEntity.status(HttpStatus.OK).body(orderItemList);
              }
		return null;
	}
			

}
