package ecommerce.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.dao.ProductRepository;
import ecommerce.entities.Product;

@Service
public class ProductService {

	@Autowired
	ProductRepository prodRep;
	
	
	public List<Product> listAll(Integer minPrice, Integer maxPrice){
		
		if (minPrice == null && maxPrice == null) {
			 return prodRep.findAll();
		}
		return prodRep.findAll()
				.stream()
				.filter(c -> c.getPrice()>minPrice && c.getPrice() < maxPrice)
				.collect(Collectors.toList());
	
	}
	
public List<Product> listAll(){
		
		
		return prodRep.findAll();
				
	}

	public Product listById(long productId) {
		// TODO Auto-generated method stub
		return prodRep.findById(productId).get();
	}

	public void deleteProduct(Product theProd) {
		// TODO Auto-generated method stub
		prodRep.delete(theProd);
		
	}
	
	
}
