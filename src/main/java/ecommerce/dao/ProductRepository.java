package ecommerce.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ecommerce.entities.Cart;
import ecommerce.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
	
	@Override
	public List<Product> findAll();

	public void save(Cart cart);
	
	
   
	//public Product findByProductId(long productId);
   
   
	
}
