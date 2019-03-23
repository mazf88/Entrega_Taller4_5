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
import com.poli.online_sale.model.OrderedProduct;
import com.poli.online_sale.repository.AddressRepository;
import com.poli.online_sale.repository.OrderedProductRepository;

@RestController
@RequestMapping("/api")
public class OrderedProductController {
	@Autowired
	OrderedProductRepository orderedProductRepository;
	
	@GetMapping("/getAllAOrderedProduct")
	public List<OrderedProduct> getAllAOrderedProduct() {
	    return orderedProductRepository.findAll();
	}
	
    @PostMapping("/createOrderedProduct")
	public OrderedProduct createOrderedProduct(@RequestBody OrderedProduct orderedProduct) {
	    return orderedProductRepository.save(orderedProduct);
	}

	@GetMapping("/getOrderedProductById/{orderedProductId}")
	public OrderedProduct getOrderedProductById(@PathVariable(value = "orderedProductId") Long orderedProductId) {
	    return orderedProductRepository.findById(orderedProductId)
	            .orElseThrow(() -> new ResourceNotFoundException("OrderedProduct", "orderedProductId", orderedProductId));
	}

	@PutMapping("/updateOrderedProduct/{orderedProductId}")
	public OrderedProduct updateorderedProduct(@PathVariable(value = "orderedProductId") Long orderedProductId,
	                                        @Valid @RequestBody OrderedProduct orderedProductDetails) {

		OrderedProduct orderedProduct = orderedProductRepository.findById(orderedProductId)
	            .orElseThrow(() -> new ResourceNotFoundException("OrderedProduct", "orderedProductId", orderedProductId));

		orderedProduct.setOrderedProductPrice(orderedProductDetails.getOrderedProductPrice());
		orderedProduct.setOrderedProductQuantity(orderedProductDetails.getOrderedProductQuantity());
		OrderedProduct updateOrderedProduct = orderedProductRepository.save(orderedProduct);
	    return updateOrderedProduct;
	}
	
	@DeleteMapping("/deleteOrderedProduct/{orderedProductId}")
	public ResponseEntity<?> deleteAddress(@PathVariable(value = "orderedProductId") Long orderedProductId) {
		OrderedProduct orderedProduct = orderedProductRepository.findById(orderedProductId)
	            .orElseThrow(() -> new ResourceNotFoundException("OrderedProduct", "orderedProductId", orderedProductId));

		orderedProductRepository.delete(orderedProduct);

	    return ResponseEntity.ok().build();
	}
}
