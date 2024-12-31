package com.truxxkart.deliveryservice_v1.service;

import java.util.List;

import com.truxxkart.deliveryservice_v1.entity.Deliveries;

public interface DeliveriesService {
	public Deliveries createDeliveries(Deliveries deliveries);
	public List<Deliveries> fetchDeliveriesByStatusAndPriority(String status,String priority);
	public List<Deliveries> fetchDeliveriesByStatus(String status);
	public List<Deliveries> fetchDeliveriesByPriority(String priority);
	public List<Deliveries> fetchDeliveriesByAgentId(Long deliveryAgentId);
	public List<Deliveries> fetchDeliveriesByUserId(Long userId);
	public List<Deliveries> fetchDeliveriesByOrderId(String orderId);
	public Deliveries fetchDeliveriesByOrderItemId(String orderItemId);
	public Deliveries acceptDelivery(Long deliveryId,Long deliveryAgentId);
	public Deliveries pickDelivery(Long deliveryId);
	public Deliveries deliveredDelivery(Long deliveryId,String note);

}
