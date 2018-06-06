package com.embaudrit.javathethird.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.embaudrit.javathethird.models.Lecture;
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
	
// This is to add sign up users to a specific course(lecture).  
//	The information submitted here will be added to the SignUp table in MySQL
	
	@RequestMapping("/courses/{id}/signup")
	public String createSignUp(@PathVariable ("id") Long id, Principal p, RedirectAttributes redirectAttributes) {
		SignUp newsignUp = new SignUp();
		Lecture currentLecture = lServ.findById(id);
		
		String username = p.getName();
		User loggedUser = uServ.findByUsername(username);
		
		newsignUp.setLecture(lServ.findById(id));
		newsignUp.setUser(loggedUser);
		
		// "For each" to compare the currentUser to the already "added" users. If matches: error. If not: add to course/lecture
		for (SignUp signUp : currentLecture.getSignUps()){
			if (signUp.getUser().getId() == loggedUser.getId() && signUp.getLecture().getId() == id ) {	
				redirectAttributes.addFlashAttribute("errors", "You have already signed up for this Course!");
				return "redirect:/courses";	
			} 	
		}
		
		if (currentLecture.getSignUps().size() >= currentLecture.getEl_limite()) {
			redirectAttributes.addFlashAttribute("errors", "This course cannot accept more sign ups");
			return "redirect:/courses";
		}
		
		redirectAttributes.addFlashAttribute("errors", "Congratulations you have signe up for: " + currentLecture.getName());
		suServ.addSignUp(newsignUp);
		
		return "redirect:/courses"; //THIS MAY CHANGE IN A WHILE. nOT QUITE SURE IF THIS IS THE CORRECT ROUTE
	}
//**********************************
// HOW TO SET THE SIGN UP LIMIT?
//		https://docs.oracle.com/javase/8/docs/api/java/time/temporal/ValueRange.html
//		https://docs.oracle.com/javase/8/docs/api/java/time/temporal/ValueRange.html#checkValidIntValue-long-java.time.temporal.TemporalField-
//		https://docs.oracle.com/javase/8/docs/api/java/time/temporal/ValueRange.html#isValidIntValue-long-
//**********************************
	
	

	
	// To sort the order of the attendees for the specific course in a descending or ascending one
	@RequestMapping(value= {"/courses/{id}/signup_{order}"})
	public String indexSignUp(@PathVariable("id") Long id, @PathVariable ("order") String order, Principal principal, Model m) {
		String username = principal.getName();
		//The new 2 lines (the ones from the exam with the likes)
    	Lecture lecture = lServ.findById(id);
    	@SuppressWarnings("unused")
		List<SignUp> singups = lecture.getSignUps();
    	//
		m.addAttribute("lecture", lServ.findById(id));
		m.addAttribute("currentUser", uServ.findByUsername(username));
		m.addAttribute("currentUserId", uServ.findByUsername(username).getId());
		//THE FOLLOWING LINES WORK! JUST COMMENTED FOR FUNSIES
//		if (order.equals("asc")) {
//			m.addAttribute("signups", suServ.findAllAsc());
//		} else if (order.equals("desc" )) {
//			m.addAttribute("signups", suServ.findAllDesc());
//		} else {
//			m.addAttribute("signups", suServ.findAll());
//		}
		
		return "showCourse.jsp";
	}
	
	// To remove the relationship between an user and a lecture
	@RequestMapping ("/courses/{id}/remove/{suid}")
	public String removeSignUp(@PathVariable("id") Long id, @PathVariable("suid") Long suid, Principal p) {
		SignUp signUp = suServ.findById(suid);
		suServ.removeSignUp(signUp);
		return ("redirect:/courses/"+id);				
	}

}
