package com.poli.online_sale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poli.online_sale.model.Costumer;

@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Long> {

}
