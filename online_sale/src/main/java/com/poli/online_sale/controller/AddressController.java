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
import com.poli.online_sale.repository.AddressRepository;

@RestController
@RequestMapping("/api")
public class AddressController {
	@Autowired
    AddressRepository addressRepository;
	
	@GetMapping("/getAllAddress")
	public List<Address> getAllAddress() {
	    return addressRepository.findAll();
	}
	
    @PostMapping("/createAddress")
	public Address createAddress(@RequestBody Address address) {
	    return addressRepository.save(address);
	}

	@GetMapping("/getAddressById/{addressId}")
	public Address getAddressById(@PathVariable(value = "addressId") Long addressId) {
	    return addressRepository.findById(addressId)
	            .orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId));
	}

	@PutMapping("/updateAddres/{addressId}")
	public Address updateAddres(@PathVariable(value = "addressId") Long addressId,
	                                        @Valid @RequestBody Address addressDetails) {

		Address address = addressRepository.findById(addressId)
	            .orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId));

		address.setAddressStreet(addressDetails.getAddressStreet());
		address.setAddressType(addressDetails.getAddressType());

		Address updateAddres = addressRepository.save(address);
	    return updateAddres;
	}
	
	@DeleteMapping("/deleteAddress/{addressId}")
	public ResponseEntity<?> deleteAddress(@PathVariable(value = "addressId") Long addressId) {
		Address address = addressRepository.findById(addressId)
	            .orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId));

		addressRepository.delete(address);

	    return ResponseEntity.ok().build();
	}
}
