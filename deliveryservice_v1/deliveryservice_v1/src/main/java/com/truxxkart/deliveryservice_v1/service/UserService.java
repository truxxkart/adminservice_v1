package com.truxxkart.deliveryservice_v1.service;



import com.truxxkart.deliveryservice_v1.entity.User;



public interface UserService {
	  public User createDeliveryAgent(User deliveryAgent);
	   public User getDeliveryAgentById(Long id);
	   public User updateDeliveryAgent(User deliveryAgent);
	   public User findByEmail(String email);
}
