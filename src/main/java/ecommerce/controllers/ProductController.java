package ecommerce.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ecommerce.dao.CartRepository;
import ecommerce.dao.CustomerRepository;
import ecommerce.dao.ProductRepository;
import ecommerce.entities.Customer;
import ecommerce.entities.Product;
import ecommerce.services.CartService;
import ecommerce.services.CustomerService;
import ecommerce.services.ProductService;

@Controller
@RequestMapping("/products")

public class ProductController {
	
     @Autowired
     ProductService prodService;
     
     @Autowired
     CustomerRepository custRepo;
     
     @Autowired
     ProductRepository prodRepo;
     
     @Autowired
     CartRepository cartRepo;
     
     @Autowired
     CustomerService custService;
     

   
     @Autowired
     CartService cartService;
	
	@GetMapping
	public String displayProducts(Model model, 
			@Param(value = "minPrice") Integer minPrice,
			@Param(value = "maxPrice") Integer maxPrice) throws JsonProcessingException {
	
		
		List <Product> products = prodService.listAll(minPrice,maxPrice);
		System.out.println(products);
		System.out.println("Min price: "+" "+ minPrice + " @@@@@@@@@"+" ");
		System.out.println("Max price: "+" "+ maxPrice + " @@@@@@@@@"+" ");
		//get maximum price of a product
		Optional<Product> productWithMaxPrice = products.
				stream().
				max(Comparator.
				comparing(Product::getPrice));
		
		float maximumPrice = productWithMaxPrice.get().getPrice();
		
		System.out.println("--------------" + maxPrice + "---------------");
	
	 System.out.println(cartRepo.findAll().toString());
		model.addAttribute("products", products);
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(products);
		model.addAttribute("productsJson", jsonString);
		model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("minPrice", minPrice);
		System.out.println(jsonString);
	

		return "Products/productsList";
	}
	
	
	  @PostMapping(value = "/products/add/", produces = "application/json")
	  public String addProductToCart (@RequestParam("id") long productId,
			@RequestParam("qty") Integer quantity,
			  Model model) { 
		
		Customer currentlyLoggedInCustomer = custRepo.findByFirstName("Safta");
		  Product productToBuy = prodService.listById(productId);
		  model.addAttribute("productToBuy", productToBuy);
		  System.out.println(productToBuy);
		  productToBuy.setQuantity(quantity);
		  model.addAttribute("productToCart",productToBuy);
		  System.out.println("Customer " +currentlyLoggedInCustomer.getFirstName()+" bought" + quantity + " "+ productToBuy.getName());
	      cartService.addToCart(currentlyLoggedInCustomer, productToBuy);
     return "redirect:/products";
     }
	  
	  @GetMapping ("/new")
	  public String getProduct (Model model) {
	  Product product = new Product();
	  model.addAttribute("product",product);
	  return "Products/new-Product";
  }
	  
	  @PostMapping ("/save")
	  public String addProduct (Model model, Product product) {
		  
		  prodRepo.save(product);
		  return "redirect:/products";
	  }
	  
	@RequestMapping(path = "/update/", method = RequestMethod.GET)
	
		public String updateProduct (@RequestParam (name = "id") long id, 
				Model model) {
			
	    Product product = prodService.listById(id);
		model.addAttribute("product",product);
			return "Products/new-Product";
			
	}
    @GetMapping (path="/delete")
    public String deleteProduct (@RequestParam ("id") long id, Model model) {
    	Product theProd = prodService.listById(id);
    	prodService.deleteProduct(theProd);
    	return "redirect:/products";
    }

}
