package com.embaudrit.javabelt.controllers;

import java.security.Principal;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.embaudrit.javabelt.models.User;
import com.embaudrit.javabelt.services.UserService;
import com.embaudrit.javabelt.validator.UserValidator;

@Controller
public class controllers {
	private UserService userService;
	private UserValidator userValidator;


public controllers(UserService userService, UserValidator userValidator) {
    this.userService = userService;
    this.userValidator = userValidator;
}
    
	 @RequestMapping("/registration")
	    public String registerForm(@Valid @ModelAttribute("user") User user) {
	        return "registrationPage.jsp";
	    }
	 
	 @PostMapping("/registration")
	    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
	        userValidator.validate(user, result);
	        if (result.hasErrors()) {
	            return "registrationPage.jsp";
	        }else {
	        	model.addAttribute("registrationMessage", "Registration Successful. Continue to login.");
	    		if (userService.allUsers().size() == 0) {
	    			userService.saveUserWithAdminRole(user);
	    		} else {
	    			userService.saveWithUserRole(user);
	    		}
	        return "redirect:/login";
	        }	
        }
	 
	// NEW 
	    @RequestMapping("/admin")
	    public String adminPage(Principal principal, Model model) {
	        String username = principal.getName();
	        model.addAttribute("currentUser", userService.findByUsername(username));
	        model.addAttribute("admin", userService.findRoleByName("ROLE_ADMIN"));
	        model.addAttribute("users", userService.allUsers());
	        return "adminPage.jsp";
	    }
	    
	 
	    @RequestMapping("/login")
	    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
	        if(error != null) {
	            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
	        }
	        if(logout != null) {
	            model.addAttribute("logoutMessage", "Logout Successful!");
	        }
	        return "loginPage.jsp";
	    }
	 
	    @RequestMapping(value = {"/", "/home"})
	    public String home(Principal principal, Model model) {
	        String username = principal.getName();
	        model.addAttribute("currentUser", userService.findByUsername(username));
	        Date date = new Date();
	        model.addAttribute("logintime", date);
	        return "homePage.jsp";
	    }
	    
	    @RequestMapping("/delete/{id}")
	    public String delete(@PathVariable("id") Long id) {
	    	userService.deleteUserById(id);
	        return "redirect:/admin";
	    }
	    
	    @RequestMapping("/make-admin/{id}")
	    public String makeAdmin(@PathVariable("id") Long id) {
	    	userService.makeAdmin(userService.findUserById(id));
	        return "redirect:/admin";
	    }

}