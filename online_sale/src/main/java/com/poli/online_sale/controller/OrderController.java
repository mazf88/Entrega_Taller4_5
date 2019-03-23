package com.poli.online_sale.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poli.online_sale.exception.ResourceNotFoundException;
import com.poli.online_sale.model.Address;
import com.poli.online_sale.model.Order;
import com.poli.online_sale.repository.OrderRepository;

@RestController
@RequestMapping("/api")
public class OrderController {
	@Autowired
	OrderRepository orderRepository;
	
	@GetMapping("/getAllOrder")
	public List<Order> getAllOrder() {
	    return orderRepository.findAll();
	}
	
    @PostMapping("/createOrder")
	public Order createOrder(@RequestBody Order order) {
	    return orderRepository.save(order);
	}
    
	@GetMapping("/getOrderById/{orderId}")
	public Order getOrderById(@PathVariable(value = "orderId") Long orderId) {
	    return orderRepository.findById(orderId)
	            .orElseThrow(() -> new ResourceNotFoundException("Order", "orderId", orderId));
	}

	@PutMapping("/updateOrder/{orderId}")
	public Order updateOrder(@PathVariable(value = "OrderId") Long orderId,
	                                        @Valid @RequestBody Order orderDetails) {

		Order order = orderRepository.findById(orderId)
	            .orElseThrow(() -> new ResourceNotFoundException("Order", "orderId", orderId));

		order.setBillingAddress(orderDetails.getBillingAddress());
		order.setDeliveryAddress(orderDetails.getDeliveryAddress());
		order.setCostumerId(orderDetails.getCostumerId());
		order.setOrderStatusId(orderDetails.getOrderStatusId());
		
		Order updateOrder = orderRepository.save(order);
	    return updateOrder;
	}
	
	@DeleteMapping("/deleteOrder/{orderId}")
	public ResponseEntity<?> deleteOrder(@PathVariable(value = "orderId") Long orderId) {
		Order order = orderRepository.findById(orderId)
	            .orElseThrow(() -> new ResourceNotFoundException("Order", "orderId", orderId));

		orderRepository.delete(order);

	    return ResponseEntity.ok().build();
	}

}
