package com.embaudrit.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class HellohumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellohumanApplication.class, args);
	}
	
//	At first, I put this model into HelloHumanController.java, but the server kept mentioning a 404 error. 
//	Once here, it worked as intended. This laptop and its mysterious ways!
    @RequestMapping("/")
    public String index(@RequestParam(value="name", defaultValue = "Human") String query, Model model) {
        model.addAttribute("name", query);
        return "index.jsp";
    }
    
}
