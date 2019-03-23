package com.poli.online_sale.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.poli.online_sale.model.OrderStatus;

@Repository
public interface OrderStatusRepository extends JpaRepositoryImplementation<OrderStatus, Long>{

}
