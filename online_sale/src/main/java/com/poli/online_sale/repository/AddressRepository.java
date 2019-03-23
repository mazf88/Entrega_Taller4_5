package com.poli.online_sale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poli.online_sale.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
