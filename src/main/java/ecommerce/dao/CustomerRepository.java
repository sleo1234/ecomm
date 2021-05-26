package ecommerce.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import ecommerce.entities.Cart;
import ecommerce.entities.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long>{

	@Override
	public List <Customer> findAll();

	public void save(Cart cart);
    
	///public Customer findById(long customer_id);
	
	@Query(value = "SELECT * FROM customer WHERE first_name = ?1")
	public Customer findByFirstName (String first_name);
	
	public Customer findByCart (Cart cart);
	
}
