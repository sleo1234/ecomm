package ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.dao.CartRepository;
import ecommerce.entities.Cart;
import ecommerce.entities.Customer;
import ecommerce.entities.Product;

@Service
public class CartService {

	
	@Autowired
	private CartRepository cartRepo;
	
	
	@Autowired
	private ProductService prodService;
	
	@Autowired
	CustomerService custService;
	
	
	public Cart addToCart(Customer customer, Product product) {
		List <Customer> customers = new ArrayList<Customer>();
		List <Product> products = new ArrayList<Product>();

		customers.add(customer);
		products.add(product);
		
		Cart cart = new Cart(products,customers);
		customer.setCart(cart);
		product.setCart(cart);
	     return cartRepo.save(cart);
	}

	public List<Cart> listAll() {
		// TODO Auto-generated method stub
		return cartRepo.findAll();
	}

	public Cart listById(long cartId) {
		// TODO Auto-generated method stub
		return cartRepo.findById(cartId).get();
	}

	
	
}
