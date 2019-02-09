package com.customer.customer_demo.HtmlController;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

public class OopsController implements ErrorController {
	
	@RequestMapping("/error")
	public String error() {
		
		
		return "oops.html";
	}

	@Override
	public String getErrorPath() {
		
		return "/error";
	}
}
