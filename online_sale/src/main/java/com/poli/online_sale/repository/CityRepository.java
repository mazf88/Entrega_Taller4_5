package com.poli.online_sale.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.poli.online_sale.controller.Response;
import com.poli.online_sale.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	public Response save(long id);

	public City findById(long id);
	
	public Response deleteById(long id);
	
	public List<City> findAll();

}
