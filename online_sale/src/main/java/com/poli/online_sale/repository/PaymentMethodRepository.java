package com.poli.online_sale.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.poli.online_sale.controller.Response;
import com.poli.online_sale.model.PaymentMethod;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

	public Response save(long id);

	public PaymentMethod findById(long id);

	public Response deleteById(long id);
	
	public List<PaymentMethod> findAll();
}