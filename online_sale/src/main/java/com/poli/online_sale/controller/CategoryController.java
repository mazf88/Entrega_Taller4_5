package com.poli.online_sale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.poli.online_sale.model.Category;
import com.poli.online_sale.repository.CategoryRepository;

@RestController
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepositoryDAO;

	@RequestMapping(path = "/addCategory", method = RequestMethod.POST)
	public @ResponseBody Response addNewProduct(@RequestParam long categoryId, @RequestParam String caregotyName,
			@RequestParam int caregotyState) {

		Category category = new Category();
		Response response = new Response();
		category.setCategoryId(categoryId);
		category.setCategoryName(caregotyName);
		category.setCategoryState(caregotyState);

		categoryRepositoryDAO.save(category);

		response.setCode(100);
		response.setDescription("Categoria creada exitosamente");

		return response;

	}

	@RequestMapping(path = "/getCategoryById", method = RequestMethod.POST)
	public Category getProductById(@RequestParam long categoryId) {
		return categoryRepositoryDAO.findById(categoryId);

	}

	@RequestMapping(path = "/deleteCategory", method = RequestMethod.POST)
	public Response deleteProductById(@RequestParam long cityId) {
		categoryRepositoryDAO.deleteById(cityId);
		Response response = new Response();
		response.setCode(100);
		response.setDescription("Categoria eliminada exitosamente");
		return response;

	}

	@RequestMapping("/getAllCategory")
	public Iterable<Category> getAllCategories() {

		Iterable<Category> listCategory = categoryRepositoryDAO.findAll();

		return listCategory;

	}
}