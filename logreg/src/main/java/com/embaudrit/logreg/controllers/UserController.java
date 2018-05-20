package com.embaudrit.logreg.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.embaudrit.logreg.models.User;
import com.embaudrit.logreg.services.UserService;
import com.embaudrit.logreg.validator.UserValidator;

@Controller
public class UserController {
    private UserService userService;
    private UserValidator userValidator;
    
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user, 
    		BindingResult result) {
        return "index.jsp";
    }
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, 
    		BindingResult result, Model model, 
    		HttpSession session) {
    	userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "index.jsp";
        }
        System.out.println("Print this pretty please");
              
        if (userService.findRoleByName("ROLE_ADMIN").getUsers().size() == 0) {
        	userService.saveUserWithAdminRole(user);
		} else {
			userService.saveWithUserRole(user);
		}
        return "redirect:/registration";
    }
    
    @RequestMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user, BindingResult result,
    		@RequestParam(value="error", required=false) String error, 
    		@RequestParam(value="logout", required=false) String logout, 
    		Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "index.jsp";
    }
    
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "homePage.jsp";
    }
}