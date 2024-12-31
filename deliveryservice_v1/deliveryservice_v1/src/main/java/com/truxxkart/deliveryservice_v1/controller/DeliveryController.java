package com.truxxkart.deliveryservice_v1.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truxxkart.deliveryservice_v1.entity.User;
import com.truxxkart.deliveryservice_v1.serviceImpl.UserServiceImpl;





@RestController
@RequestMapping("/delivery-agent")
public class DeliveryController {
	@Autowired
	private UserServiceImpl userService;
	
	

	@PostMapping()
	public ResponseEntity<User> createUser(@RequestBody User delivaryAgent){
		User createdUser =userService.createDeliveryAgent(delivaryAgent);
		return new ResponseEntity<User>(createdUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<User> getUsersById(@PathVariable Long id){
		User userById =userService.getDeliveryAgentById(id);
		return new ResponseEntity<User>(userById,HttpStatus.OK);
	}
	
 
}
