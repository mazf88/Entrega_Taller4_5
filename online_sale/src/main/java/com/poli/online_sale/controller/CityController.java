package com.poli.online_sale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.poli.online_sale.model.City;
import com.poli.online_sale.repository.CityRepository;

@RestController
public class CityController {

	@Autowired
	private CityRepository cityRepositoryDAO;

	@RequestMapping(path = "/addCity", method = RequestMethod.POST)
	public @ResponseBody Response addNewCity(@RequestParam long cityId, @RequestParam String name) {

		City city = new City();
		Response response = new Response();
		city.setCityId(cityId);
		city.setCitiName(name);
		cityRepositoryDAO.save(city);

		response.setCode(100);
		response.setDescription("Ciudad creada exitosamente");

		return response;

	}

	@RequestMapping(path = "/getCityById", method = RequestMethod.POST)
	public City getCityById(@RequestParam long cityId) {
		return cityRepositoryDAO.findById(cityId);

	}

	@RequestMapping(path = "/deleteCity", method = RequestMethod.POST)
	public Response deletetweetById(@RequestParam long cityId) {
		cityRepositoryDAO.deleteById(cityId);
		Response response = new Response();
		response.setCode(100);
		response.setDescription("Ciudad eliminada exitosamente");
		return response;

	}

	@RequestMapping("/getAllCities")
	public Iterable<City> getAllCities() {

		Iterable<City> listCity = cityRepositoryDAO.findAll();

		return listCity;

	}
}
