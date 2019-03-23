package com.poli.online_sale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.poli.online_sale.model.Category;
import com.poli.online_sale.model.Product;
import com.poli.online_sale.repository.CategoryRepository;
import com.poli.online_sale.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepositoryDAO;

	@Autowired
	private CategoryRepository categoryRepositoryDAO;

	@RequestMapping(path = "/addProduct", method = RequestMethod.POST)
	public @ResponseBody Response addNewProduct(@RequestParam long productId, @RequestParam long categoryid,
			@RequestParam String productName, @RequestParam long productPrice, @RequestParam int productState) {

		Product product = new Product();
		Category category = categoryRepositoryDAO.findById(categoryid);
		Response response = new Response();
		product.setProductId(productId);
		product.setCategory(category);
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product.setProductState(productState);
		productRepositoryDAO.save(product);

		response.setCode(100);
		response.setDescription("Producto creado exitosamente");

		return response;

	}

	@RequestMapping(path = "/getProductById", method = RequestMethod.POST)
	public Product getProductById(@RequestParam long productId) {
		return productRepositoryDAO.findById(productId);

	}

	@RequestMapping(path = "/deleteProduct", method = RequestMethod.POST)
	public Response deleteProductById(@RequestParam long cityId) {
		productRepositoryDAO.deleteById(cityId);
		Response response = new Response();
		response.setCode(100);
		response.setDescription("Producto eliminado exitosamente");
		return response;

	}

	@RequestMapping("/getAllProduct")
	public Iterable<Product> getAllTweet() {

		Iterable<Product> listProduct = productRepositoryDAO.findAll();

		return listProduct;

	}
}
