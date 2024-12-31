package com.truxxkart.deliveryservice_v1.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truxxkart.deliveryservice_v1.entity.Deliveries;
import com.truxxkart.deliveryservice_v1.enums.DeliveryEnums;
import com.truxxkart.deliveryservice_v1.repository.DeliveriesRepository;
import com.truxxkart.deliveryservice_v1.service.DeliveriesService;

@Service
public class DeliveriesServiceImpl implements DeliveriesService {
	@Autowired
     private  DeliveriesRepository delRepo;
	@Override
	public Deliveries createDeliveries(Deliveries deliveries) {
		Deliveries delivery = delRepo.save(deliveries);
		return delivery;
	}

	@Override
	public List<Deliveries> fetchDeliveriesByStatusAndPriority(String status, String priority) {
		Optional<List<Deliveries>> optDeliveryList = delRepo.findByStatusAndPriority(DeliveryEnums.valueOf(status), DeliveryEnums.valueOf(priority));
		if(optDeliveryList.isPresent()) {
			return optDeliveryList.get();
		}
		return null;
	}

	@Override
	public List<Deliveries> fetchDeliveriesByStatus(String status) {
		Optional<List<Deliveries>> optDeliveryList = delRepo.findByStatus(DeliveryEnums.valueOf(status));
		if(optDeliveryList.isPresent()) {
			return optDeliveryList.get();
		}
		return null;
		
		
	}

	@Override
	public List<Deliveries> fetchDeliveriesByPriority(String priority) {
		Optional<List<Deliveries>> optDeliveryList = delRepo.findByPriority(DeliveryEnums.valueOf(priority));
		if(optDeliveryList.isPresent()) {
			return optDeliveryList.get();
		}
		return null;
	}

	@Override
	public List<Deliveries> fetchDeliveriesByAgentId(Long deliveryAgentId) {
		Optional<List<Deliveries>> optDeliveryList = delRepo.findByDeliveryAgentId(deliveryAgentId);
		if(optDeliveryList.isPresent()) {
			return optDeliveryList.get();
		}
		return null;
	}

	@Override
	public List<Deliveries> fetchDeliveriesByUserId(Long userId) {
		Optional<List<Deliveries>> optDeliveryList = delRepo.findByUserId(userId);
		if(optDeliveryList.isPresent()) {
			return optDeliveryList.get();
		}
		return null;
	}

	@Override
	public List<Deliveries> fetchDeliveriesByOrderId(String orderId) {
		Optional<List<Deliveries>> optDeliveryList = delRepo.findByOrderId(orderId);
		if(optDeliveryList.isPresent()) {
			return optDeliveryList.get();
		}
		return null;
	}

	@Override
	public Deliveries fetchDeliveriesByOrderItemId(String orderItemId) {
		Optional<Deliveries> optDelivery = delRepo.findByOrderItemId(orderItemId);
		if(optDelivery.isPresent()) {
			return optDelivery.get();
		}
		
		return null;
	}
	
	// Add check for delivery status 

	@Override
	public Deliveries acceptDelivery(Long deliveryId,Long deliveryAgentId) {
		Optional<Deliveries> optDel =delRepo.findById(deliveryId);
		if(optDel.isPresent()) {
			Deliveries del=optDel.get();
			del.setDeliveryAgentId(deliveryAgentId);
			del.setAccepted(true);
			del.setStatus(DeliveryEnums.valueOf("PROCESSING"));
			return delRepo.save(del);
		}
		return null;
	}

	@Override
	public Deliveries pickDelivery(Long deliveryId) {
		Optional<Deliveries> optDel =delRepo.findById(deliveryId);
		if(optDel.isPresent()) {
			Deliveries del=optDel.get();
			del.setPickupTime(LocalDateTime.now());
			del.setStatus(DeliveryEnums.valueOf("PICKED"));
			return delRepo.save(del);
		}
		return null;
	}

	@Override
	public Deliveries deliveredDelivery(Long deliveryId,String note) {
		Optional<Deliveries> optDel =delRepo.findById(deliveryId);
		if(optDel.isPresent()) {
			Deliveries del=optDel.get();
			del.setDeliveryNote(note);
			del.setDeliveredTime(LocalDateTime.now());
			del.setStatus(DeliveryEnums.valueOf("DELIVERED"));
			return delRepo.save(del);
		}
		return null;
	}

}
