package com.truxxkart.deliveryservice_v1.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truxxkart.deliveryservice_v1.entity.User;
import com.truxxkart.deliveryservice_v1.repository.UserRepository;
import com.truxxkart.deliveryservice_v1.service.UserService;


@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User createDeliveryAgent(User deliveryAgent) {
		User createdUser =userRepo.save(deliveryAgent);
		return createdUser;
	}



	@Override
	public User getDeliveryAgentById(Long id) {
		User userById = userRepo.findById(id).get();
	return userById;
	}

	@Override
	public User updateDeliveryAgent(User deliveryAgent) {
		User myUser = userRepo.findById(deliveryAgent.getId()).get();
		if(myUser!=null) {
			myUser=userRepo.save(deliveryAgent);
		}
		return myUser;
	}

	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmail(email).get();
	}

}