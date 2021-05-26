package ecommerce.api.comtrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.dao.CartRepository;
import ecommerce.dao.CustomerRepository;
import ecommerce.dao.ProductRepository;
import ecommerce.entities.Cart;
import ecommerce.entities.Customer;
import ecommerce.entities.Product;
import ecommerce.services.CartService;
import ecommerce.services.CustomerService;
import ecommerce.services.ProductService;

@RequestMapping("/api/customers")
@RestController

public class CustomerApiController {

	
	@Autowired
	ProductService prodService;

	@Autowired
	CartService cartService;


	@Autowired
	CustomerRepository custRepo;
	
	@Autowired
	ProductRepository prodRepo;
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	CustomerService custService;
	
	List <Product> products = new ArrayList<Product>();
	
	@GetMapping 
	public List <Customer> getAllCustomers (){
		
		return custService.listAll();
	}
	
	@PatchMapping("/{customerId}/{productId}/")
	@ResponseStatus(HttpStatus.OK)
	public Customer updateCustomer (@PathVariable("customerId") long customer,
			 @PathVariable("productId") long productId,
			 @RequestBody Customer customerToBeUpdated) {
		
	if (customerToBeUpdated.getCart()==null) {
		Cart cart = new Cart ();
		cartRepo.save(cart);
		
	}
		Cart cart = customerToBeUpdated.getCart();
		products.add(prodService.listById(productId));
		cart.setProduct(products);
				
				//listByCart(cartService.listById(cartId));
		Product productToBeAdded = prodService.listById(productId);
		
	
		return custRepo.save(customerToBeUpdated);
	}
	
//	@PatchMapping("/{customerId}")
//	@ResponseStatus(HttpStatus.OK)
//	public Customer setCartForCustomer (@PathVariable("customerId") long customerId,
//			@RequestBody Customer patchCustomer) {
//	Customer customer = custService.listById(customerId);
//	
//	if (patchCustomer.getCart() != null) {
//		customer.setCart(patchCustomer.getCart());
//		
//	}
//	
//	else if (patchCustomer.getCart() == null) {
//		Cart cart = new Cart();
//		customer.setCart(cart);
//	}
//	return customer;
//	}
	
	@PutMapping (consumes = "application/json")
	@ResponseStatus (HttpStatus.OK)
	public Customer editCutomer (

	@RequestBody Customer patchCustomer) {
		
		return custRepo.save(patchCustomer);
	}
}
