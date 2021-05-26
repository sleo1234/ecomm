package ecommerce.api.comtrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.dao.CartRepository;
import ecommerce.dao.CustomerRepository;
import ecommerce.dao.ProductRepository;
import ecommerce.entities.Cart;
import ecommerce.entities.Product;
import ecommerce.services.CartService;
import ecommerce.services.ProductService;

@RequestMapping("api/products")
@RestController
public class ProductApiController {
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
	public List<Product> getAllProducts() {

		return prodService.listAll();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id")long id) {

		return prodService.listById(id);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct (@RequestBody Product product) {
		
		return prodRepo.save(product);
	}
	
	@PatchMapping (path= "/{productId}/{cartId}",consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	
	public Product updateProduct (@PathVariable("productId") long productId, @PathVariable("cartId") long cartId,
			@RequestBody Product productToBeUpdated) {
		
				
		Product patchProduct = prodService.listById(productId);
		if (productToBeUpdated.getCategory() != null) {
			patchProduct.setCategory(productToBeUpdated.getCategory());
		}
		if (productToBeUpdated.getDescription() != null) {
			patchProduct.setDescription(productToBeUpdated.getDescription());
		}
		
		if (productToBeUpdated.getManufacturer() != null) {
			patchProduct.setManufacturer(productToBeUpdated.getManufacturer() );
		}
		if (productToBeUpdated.getImageUrl() != null) {
			patchProduct.setImageUrl(productToBeUpdated.getImageUrl());
		}
		
		if (productToBeUpdated.getPrice() != 0.0f) {
			patchProduct.setPrice(productToBeUpdated.getPrice());
		}
		if (productToBeUpdated.getQuantity() != null) {
			patchProduct.setQuantity(productToBeUpdated.getQuantity());
		}
		if (productToBeUpdated.getCart() == null) {
			patchProduct.setCart(cartRepo.findById(cartId).get());
		}
		
		return prodRepo.save(productToBeUpdated);
	}
	
	@PutMapping (consumes = "application/json")
	@ResponseStatus (HttpStatus.OK)
	public Product editProduct (@RequestBody Product patchProduct) {
		
		return prodRepo.save(patchProduct);
	}
}
