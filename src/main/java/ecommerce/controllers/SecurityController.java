package ecommerce.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ecommerce.dao.CustomerRepository;
import ecommerce.dao.ProductRepository;
import ecommerce.entities.Customer;

@Controller
public class SecurityController {

	@Autowired
	CustomerRepository custRepo;
	@Autowired
	ProductRepository prodRep;
	
	@GetMapping("/register")
	public String register (Model model) {
		
		
		Customer customer = new Customer();
		model.addAttribute("customer",customer);
		
		
		return "Security/register";
	}
	
	@PostMapping("/register/save")
	public String saveUser (Model model, Customer customer)  {
	customer.setPassword(customer.getPassword());
	custRepo.save(customer);
		
	System.out.println(customer);
		return "redirect:/";
		
	}
	
	
}
