package ecommerce.api.comtrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import ecommerce.services.ProductService;

@RequestMapping("api/carts")
@RestController
public class CartApiController {

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
	
	@GetMapping
	public List <Cart> getAllCarts () {
		
		return cartRepo.findAll();
	}
	
	
//	@PatchMapping (path= "/{cartId}",consumes = "application/json")
//	@ResponseStatus(HttpStatus.OK)
//	
//	public Product updateProduct (@PathVariable("cartId") long cartId, @RequestBody Cart cartToBeupdated) {
//		List <Customer> customers = new ArrayList<Customer>();
//		List <Product> products = new ArrayList<Product>();
//     //   Customer customer = custRepo.findByFirstName("Safta");
//		customers.add(customer);
//		products.add(product);
//				
//	///Cart patchCart = cartRepo.findById(cartId).get();
//		
//		
//		
//		
//		//return cartRepo.save(cartToBeUpdated);
//	}
	
}
