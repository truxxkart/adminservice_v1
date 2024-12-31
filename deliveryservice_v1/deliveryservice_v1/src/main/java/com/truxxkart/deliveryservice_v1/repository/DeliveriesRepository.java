package com.truxxkart.deliveryservice_v1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truxxkart.deliveryservice_v1.entity.Deliveries;
import com.truxxkart.deliveryservice_v1.enums.DeliveryEnums;

public interface DeliveriesRepository extends JpaRepository<Deliveries, Long> {
	
	Optional<List<Deliveries>> findByUserId(Long userId);
	Optional<List<Deliveries>> findByDeliveryAgentId(Long deliveryAgentId);
	Optional<List<Deliveries>> findByOrderId(String orderId);
	Optional<Deliveries> findByOrderItemId(String orderItemId);
	Optional<List<Deliveries>> findByStatus(DeliveryEnums status);
	Optional<List<Deliveries>> findByPriority(DeliveryEnums priority);
	Optional<List<Deliveries>> findByStatusAndPriority(DeliveryEnums status,DeliveryEnums priority);

}
