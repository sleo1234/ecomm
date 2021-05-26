package ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.dao.CartRepository;

@Service
public class ShoppingCartService {

	@Autowired
	CartRepository cartRepo;
	
	//public Cart addProduct(long productId, Product product, Customer customer) {
		
		
		//return cartRepo.save(customer, product);
	//}
}
