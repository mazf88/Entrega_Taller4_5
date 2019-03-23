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
import com.poli.online_sale.model.OrderStatus;
import com.poli.online_sale.repository.OrderStatusRepository;

@RestController
@RequestMapping("/api")
public class OrderStatusController {
	@Autowired
	OrderStatusRepository orderStatusRepository;
	
	@GetMapping("/getAllOrderStatus")
	public List<OrderStatus> getAllOrderStatus() {
	    return orderStatusRepository.findAll();
	}
	
    @PostMapping("/createOrderStatus")
	public OrderStatus createOrderStatus(@RequestBody OrderStatus ordeStatus) {
	    return orderStatusRepository.save(ordeStatus);
	}
    
    @GetMapping("/getOrderStatusById/{orderStatusId}")
	public OrderStatus getById(@PathVariable(value = "orderStatusId") Long orderStatusId) {
	    return orderStatusRepository.findById(orderStatusId)
	            .orElseThrow(() -> new ResourceNotFoundException("OrderStatus", "orderStatusId", orderStatusId));
	}
    
	@PutMapping("/updateOrderStatus/{orderStatusId}")
	public OrderStatus update(@PathVariable(value = "orderStatusId") Long orderStatusId,
	                                        @Valid @RequestBody OrderStatus orderStatusDetails) {

		OrderStatus orderStatus = orderStatusRepository.findById(orderStatusId)
	            .orElseThrow(() -> new ResourceNotFoundException("OrderStatus", "orderStatus", orderStatusId));

		orderStatus.setOrderStatusName(orderStatusDetails.getOrderStatusName());
		OrderStatus updateOrderStatus = orderStatusRepository.save(orderStatus);
	    return updateOrderStatus;
	}
	
	@DeleteMapping("/deleteOrderStatus/{orderStatusId}")
	public ResponseEntity<?> deleteOrderStatus(@PathVariable(value = "orderStatusId") Long orderStatusId) {
		OrderStatus orderStatus = orderStatusRepository.findById(orderStatusId)
	            .orElseThrow(() -> new ResourceNotFoundException("OrderStatus", "orderStatusId", orderStatusId));

		orderStatusRepository.delete(orderStatus);

	    return ResponseEntity.ok().build();
	}

}
