package com.embaudrit.javathethird.controllers;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.embaudrit.javathethird.models.Lecture;
import com.embaudrit.javathethird.models.SignUp;
import com.embaudrit.javathethird.models.User;
import com.embaudrit.javathethird.services.LectureService;
import com.embaudrit.javathethird.services.UserService;
import com.embaudrit.javathethird.validator.UserValidator;

@Controller
public class UserController {

	private UserService uServ;
	private UserValidator uVal;
	private LectureService lServ;
	
	public UserController (UserService uServ, UserValidator uVal, LectureService lServ) {
		this.uServ = uServ;
		this.uVal = uVal;
		this.lServ = lServ;
	}
	
	// Log in --**DO NOT CHANGE!!**--
	@RequestMapping ("/login")
	public String login (@ModelAttribute ("user") User user, @RequestParam (value="error", required=false) String error, @RequestParam (value="logout", required=false) String logout, Model m) {
		if (error != null) {
			m.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
		}
		if (logout != null) {
			m.addAttribute("logoutMessage", "Logout successful!");
		}
		return "index.jsp";
	}
	
	// Registration  --**DO NOT CHANGE!!**--
	@PostMapping ("/registration")
	public String registration (@Valid @ModelAttribute("user") User user, BindingResult result, Model m, HttpSession session, HttpServletRequest request) {
		uVal.validate(user, result);
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			if (uServ.findUserByRole("ROLE_ADMIN") == null) {
				uServ.saveUserWithAdminRole(user);
			} else {
				uServ.saveUserWithUserRole(user);
			}
			try {
				request.login(user.getEmail(), user.getPasswordConfirmation());
			} catch (ServletException e) {
				e.printStackTrace();
			}
			return "redirect:/";
		}
	}
	
	
	//To take all the not recognizable routes to the main page (dashboard, "courses.jsp")
	@RequestMapping(value= {"/", "/courses"})
	public String index (Principal principal, Model m) {
		String username = principal.getName();
		m.addAttribute("currentUser", uServ.findByUsername(username));
//		m.addAttribute("currentUserId", uServ.findByUsername(username).getId());
		
		m.addAttribute("lecture", lServ.findAll());
		
		return "courses.jsp";
	}
	
	@RequestMapping(value= {"/courses/order_{order}"})
	public String indexOrder(@PathVariable ("order") String ord, Principal principal, Model m) {
		String username = principal.getName();
		m.addAttribute("currentUser", uServ.findByUsername(username));
//		m.addAttribute("currentUserId", uServ.findByUsername(username).getId());
		
		if (ord.equals("asc")) {
			m.addAttribute("lecture", lServ.findAllAsc());
		} else if (ord.equals("desc" )) {
			m.addAttribute("lecture", lServ.findAllDesc());
		} else {
			m.addAttribute("lecture", lServ.findAll());
		}
		
		return "courses.jsp";
	}
}