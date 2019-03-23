package com.poli.online_sale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.poli.online_sale.model.PaymentMethod;
import com.poli.online_sale.repository.PaymentMethodRepository;

@RestController
public class PaymentController {

	@Autowired
	private PaymentMethodRepository paymentMethodRepositoryDAO;

	@RequestMapping(path = "/addPaymentMethod", method = RequestMethod.POST)
	public @ResponseBody Response addNewProduct(@RequestParam long paymentMethodId,
			@RequestParam String paymentMethodName, @RequestParam int paymentMethodState) {

		PaymentMethod paymentMethod = new PaymentMethod();
		Response response = new Response();
//		paymentMethod.setPaymentMethodId(paymentMethodId);
//		paymentMethod.setPaymentMethodName(paymentMethodName);
//		paymentMethod.setPaymentMethodState(paymentMethodState);
		paymentMethodRepositoryDAO.save(paymentMethod);

		response.setCode(100);
		response.setDescription("Metodo de pago creado exitosamente");

		return response;

	}

	@RequestMapping(path = "/getPaymentMethodById", method = RequestMethod.POST)
	public PaymentMethod getProductById(@RequestParam long productId) {
		return paymentMethodRepositoryDAO.findById(productId);

	}

	@RequestMapping(path = "/deletePaymentMethod", method = RequestMethod.POST)
	public Response deleteProductById(@RequestParam long paymentMethodId) {
		paymentMethodRepositoryDAO.deleteById(paymentMethodId);
		Response response = new Response();
		response.setCode(100);
		response.setDescription("Metodo de pago eliminado exitosamente");
		return response;

	}

	@RequestMapping("/getAllPaymentMethod")
	public Iterable<PaymentMethod> getAllPayment() {

		Iterable<PaymentMethod> listPayment = paymentMethodRepositoryDAO.findAll();

		return listPayment;

	}
}