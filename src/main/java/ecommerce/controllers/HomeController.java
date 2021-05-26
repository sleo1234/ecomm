package ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ecommerce.dao.CustomerRepository;

import ecommerce.dao.ProductRepository;
import ecommerce.services.CustomerService;
import ecommerce.services.ProductService;



@Controller
public class HomeController {
	
	   @Autowired
	     ProductService prodService;
	     
	     @Autowired
	     CustomerRepository custRepo;
	     
	     @Autowired
	     ProductRepository prodRepo;
	     
	     @Autowired
	     CustomerService custService;
	     
	  
	   
	
	

	@GetMapping("/")
	private String displayHome (Model model) {
//		 Authentication authentication = authenticationFacade.getAuthentication();
//			System.out.println(authentication.getName());
//			Customer currentlyLoggedInCustomer = custRepo.findByFirstName(authentication.getName());
//			
//			model.addAttribute("currentlyLoggedInCustomer",currentlyLoggedInCustomer);
//			
//			long customerId = currentlyLoggedInCustomer.getCustomer_id();
//			System.out.println(customerId);
		
		return "Main/home";
	}
}
