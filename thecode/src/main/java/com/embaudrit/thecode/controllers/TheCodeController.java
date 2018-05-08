package com.embaudrit.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TheCodeController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(path = "/process",  method=RequestMethod.POST)
//	The validation of the secret word starts here. https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html
//	http://www.cafeaulait.org/course/week4/37.html
	public String process(@RequestParam("code") String code, RedirectAttributes redirect) {
		String secretCode = "bushido";
		if (code.equals(secretCode)){
			return "redirect:/code";
		}
		redirect.addFlashAttribute("error", "<h2>You must train harder!</h2>");
		return "redirect:/";
	}
	
	@RequestMapping("/code")
	public String code() {
		return "code.jsp";
	}

}
