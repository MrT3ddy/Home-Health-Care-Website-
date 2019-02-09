package com.customer.customer_demo.HtmlController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.customer.customer_demo.customerEntity.Customer;
import com.customer.customer_demo.session.CustomerServiceLayer;

@Controller
@RequestMapping("/view")
public class DataController {
	
	@Autowired
	private CustomerServiceLayer cs;
	@GetMapping("/user/listed")
	public String userViewList(Model mod){
		
		List<Customer> cus = cs.findAll();
		
		mod.addAttribute("customers", cus);
		
		return "list-customersUser.html";
		
	}
	
	@GetMapping("/admin/listed")
	public String showCustomers(Model mod) {
		
		List<Customer> cus = cs.findAll();
		
		mod.addAttribute("customers", cus);
		
		return "list-customers.html";
	}
	@PostMapping("/admin/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer cus) {
		cs.save(cus);
		
		return "redirect:/admin/listed";
	}
	
	@RequestMapping("/admin/addForm")
	public String deleteCustomer(Model mod) {
		
		Customer cus = new Customer();
		
		mod.addAttribute("customer", cus);
		
		return "Add_Update_customer.html";
	}
	
	@RequestMapping("/admin/updateForm/{id}")
	public String updateCustomer(@PathVariable("id") int id, Model mod) {
		
		Customer cus = cs.findById(id);
		
		mod.addAttribute("customer", cus);
		
		return"Add_Update_customer.html";
		
	}
	
	@RequestMapping("/admin/deleteForm/{id}")
	public String deleteCustomer(@PathVariable int id) {
		
		cs.delete(id);
		
		return "redirect:/view/listed";
	}
}
