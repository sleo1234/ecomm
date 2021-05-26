package ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.dao.CartRepository;
import ecommerce.dao.CustomerRepository;
import ecommerce.entities.Cart;
import ecommerce.entities.Customer;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository custRepo;
	@Autowired
	CartRepository cartRepo;

	
	public Customer listById (long customerId) {
		
		return custRepo.findById(customerId).get();
	}
	
	public List <Customer> listAll (){
		
		return custRepo.findAll();
	}
	
	public Customer listByCart (Cart cart) {
		return custRepo.findByCart(cart);
	}
}
