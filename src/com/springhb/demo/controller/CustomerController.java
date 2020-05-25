package com.springhb.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springhb.demo.dao.CustomerDAO;
import com.springhb.demo.entity.Customer;
import com.springhb.demo.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	//private CustomerDAO customerDAO;
	private CustomerService customerService;
	
	//@RequestMapping("/list")
	@GetMapping("/list")
	public String getPlayers(Model model)
	{
		List<Customer> customers = customerService.getCustomers();
		for(Customer c : customers)
		{
			System.out.println("** "+c.getFirstName()+" "+c.getLastName()+" "+c.getEmail());
		}
		model.addAttribute("customers", customers);
		return("view-customers");
		
	}
	@GetMapping("/addCustomer")
	public String showForm(Model model)
	{
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "add-customer";
		
	}
	@PostMapping("/saveCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer customer)
	{
		//Customer customer = new Customer();
		customerService.saveCustomer(customer);
		return "redirect:/customers/list";
		
	}
	@GetMapping("/update")
	public String updateForm(@RequestParam("customerId") int id,Model model)
	{
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "add-customer";
		
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id,Model model)
	{
		customerService.deleteCustomer(id);
		return "redirect:/customers/list";
		
	}
}
