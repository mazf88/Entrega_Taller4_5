package com.poli.online_sale.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.poli.online_sale.exception.ResourceNotFoundException;
import com.poli.online_sale.model.Costumer;
import com.poli.online_sale.repository.CostumerRepository;

@RestController
@RequestMapping("/api")
public class CostumerController {

	@Autowired
    CostumerRepository costumerRepository;
	
	// Get All Costumer
	@GetMapping("/getAllCostumer")
	public List<Costumer> getAllCostumer() {
	    return costumerRepository.findAll();
	}
	
    // Create a new Costumer
	@PostMapping("/createCostumer")
	public Costumer createCostumer(@RequestBody Costumer costumer) {
	    return costumerRepository.save(costumer);
	}
	
    // Get a Single Costumer
	@GetMapping("/getCostumerById/{costumerId}")
	public Costumer getCostumerById(@PathVariable(value = "costumerId") Long costumerId) {
	    return costumerRepository.findById(costumerId)
	            .orElseThrow(() -> new ResourceNotFoundException("Costumer", "costumerId", costumerId));
	}
	
    // Update a Costumer
	@PutMapping("/updateCostumer/{costumerId}")
	public Costumer updateCostumer(@PathVariable(value = "costumerId") Long costumerId,
	                                        @Valid @RequestBody Costumer costumerDetails) {

	
//		Costumer costumer = costumerRepository.findById(costumerId)
//	            .orElseThrow(() -> new ResourceNotFoundException("Costumer", "costumerId", costumerId));
//
//		costumer.setCostumerName(costumerDetails.getCostumerName());
//		costumer.setCostumerEmail(costumerDetails.getCostumerEmail());
//
//	    Costumer updatedCostumer = costumerRepository.save(costumer);
	    return null;
	}
	
    // Delete a Costumer
	@DeleteMapping("/deleteCustomer/{costumerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable(value = "costumerId") Long costumerId) {
	    Costumer costumer = costumerRepository.findById(costumerId)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "costumerId", costumerId));

	    costumerRepository.delete(costumer);

	    return ResponseEntity.ok().build();
	}
}
