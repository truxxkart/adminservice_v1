package com.truxxkart.deliveryservice_v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.truxxkart.deliveryservice_v1.entity.Deliveries;
import com.truxxkart.deliveryservice_v1.service.DeliveriesService;

@RestController
@RequestMapping("/deliveries")
public class DeliveriesController {
	
	@Autowired
	private DeliveriesService deliveriesService;
	
	@PostMapping()
	public ResponseEntity<Deliveries> createDeliveries(@RequestBody Deliveries deliveries){
		Deliveries createdDeliveries = deliveriesService.createDeliveries(deliveries);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdDeliveries);
	}
	
	@GetMapping("/status/priority")
	public ResponseEntity<List<Deliveries>> fetchDeliveriesByStatusAndPriority(@RequestParam String status,@RequestParam String priority){
		List<Deliveries> delList=deliveriesService.fetchDeliveriesByStatusAndPriority(status, priority);
		return ResponseEntity.status(HttpStatus.OK).body(delList);
		
	}
	
	@GetMapping("/status")
	public ResponseEntity<List<Deliveries>> fetchDeliveriesByStatus(@RequestParam String status){
		List<Deliveries> delList=deliveriesService.fetchDeliveriesByStatus(status);
		return ResponseEntity.status(HttpStatus.OK).body(delList);
		
	}
	@GetMapping("/priority")
	public ResponseEntity<List<Deliveries>> fetchDeliveriesByPriority(@RequestParam String priority){
		List<Deliveries> delList=deliveriesService.fetchDeliveriesByPriority(priority);
		return ResponseEntity.status(HttpStatus.OK).body(delList);
		
	}
	@GetMapping("/agent/{delAgentId}")
	public ResponseEntity<List<Deliveries>> fetchDeliveriesByAgentId(@PathVariable Long delAgentId){
		List<Deliveries> delList=deliveriesService.fetchDeliveriesByAgentId(delAgentId);
		return ResponseEntity.status(HttpStatus.OK).body(delList);
		
	}
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Deliveries>> fetchDeliveriesByUserId(@PathVariable Long userId){
		List<Deliveries> delList=deliveriesService.fetchDeliveriesByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(delList);
		
	}
	@GetMapping("/order/{orderId}")
	public ResponseEntity<List<Deliveries>> fetchDeliveriesByOrderId(@PathVariable String orderId){
		List<Deliveries> delList=deliveriesService.fetchDeliveriesByOrderId(orderId);
		return ResponseEntity.status(HttpStatus.OK).body(delList);
		
	}
	@GetMapping("/order-item/{orderItemId}")
	public ResponseEntity<Deliveries> fetchDeliveriesByOrderItemId(@PathVariable String orderItemId){
		Deliveries del=deliveriesService.fetchDeliveriesByOrderItemId(orderItemId);
		return ResponseEntity.status(HttpStatus.OK).body(del);
		
	}
	
	@PutMapping("/accepted/{deliveryId}/agent-id/{deliveryAgentId}")
	public ResponseEntity<Deliveries> acceptDelivery(@PathVariable Long deliveryId,@PathVariable Long deliveryAgentId){
		Deliveries del=deliveriesService.acceptDelivery(deliveryId,deliveryAgentId);
		return ResponseEntity.status(HttpStatus.OK).body(del);
		
	}
	@PutMapping("/picked/{deliveryId}")
	public ResponseEntity<Deliveries> pickDelivery(@PathVariable Long deliveryId){
		Deliveries del=deliveriesService.pickDelivery(deliveryId);
		return ResponseEntity.status(HttpStatus.OK).body(del);
		
	}
	@PutMapping("/delivered/{deliveryId}")
	public ResponseEntity<Deliveries> deliveredDelivery(@PathVariable Long deliveryId,@RequestBody String note){
		Deliveries del=deliveriesService.deliveredDelivery(deliveryId, note);
		return ResponseEntity.status(HttpStatus.OK).body(del);
		
	}

}
