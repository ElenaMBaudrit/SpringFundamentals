package com.embaudrit.javathethird.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.embaudrit.javathethird.models.SignUp;
import com.embaudrit.javathethird.models.User;
import com.embaudrit.javathethird.services.LectureService;
import com.embaudrit.javathethird.services.SignUpService;
import com.embaudrit.javathethird.services.UserService;

@Controller
public class SignUpController {
	private SignUpService suServ;
	private UserService uServ;
	private LectureService lServ;
	
	public SignUpController(SignUpService suServ, UserService uServ, LectureService lServ) {
		this.suServ = suServ;
		this.uServ = uServ;
		this.lServ = lServ;
	}
	
	
	@RequestMapping("/courses/{id}/signup")
	public String createSignUp(@PathVariable ("id") Long id, Principal p) {
		SignUp newsignUp = new SignUp();
		
		String username = p.getName();
		User loggedUser = uServ.findByUsername(username);
		
		newsignUp.setLecture(lServ.findById(id));
		newsignUp.setUser(loggedUser);
		
		suServ.addSignUp(newsignUp);
		return "redirect:/courses"; //THIS MAY CHANGE IN A WHILE. nOT QUITE SURE IF THIS IS THE CORRECT ROUTE
		
		
//		signUp.setUser(loggedUser);
//		signUp.setLecture(lServ.findById(id));	
	}
	
//	@PostMapping ("/courses/{id}/signup")
//	public String createSignUp(@Valid @ModelAttribute("signup") SignUp signup, BindingResult result, @PathVariable ("id") Long id) {
//		if (result.hasErrors()) {
//			return "courses.jsp";
//		}else {
//			suServ.addSignUp(signup);
//			return "redirect:/courses";
//		}
//	}
	
	

}
