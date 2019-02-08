package com.customer.customer_demo.HtmlController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageControllers {

	@RequestMapping("/")
	public String home(){
		
		return "home.html";
	}
}
