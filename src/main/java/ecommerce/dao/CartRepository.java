package ecommerce.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ecommerce.entities.Cart;
import ecommerce.entities.Customer;
import ecommerce.entities.Product;

public interface CartRepository extends CrudRepository<Cart, Long>{

	//public Cart save(List<Customer> customer);
	//public Cart save(List <Product> product);
	
	@Override
	public List <Cart> findAll();
	
	public void save(Product product);
	public void save(Customer customer);
	
}
