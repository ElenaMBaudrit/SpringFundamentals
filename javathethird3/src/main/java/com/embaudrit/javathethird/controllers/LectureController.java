package com.embaudrit.javathethird.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.embaudrit.javathethird.models.Lecture;
import com.embaudrit.javathethird.models.SignUp;
import com.embaudrit.javathethird.services.LectureService;
import com.embaudrit.javathethird.services.UserService;

@Controller
public class LectureController {
	
	//Inject Services
	private LectureService lServ;
	private UserService uServ;
	
	public LectureController (LectureService lServ, UserService uServ) {
		this.lServ = lServ;
		this.uServ = uServ;
	}
	
	// To display the newCourse.jsp, where the user could add a new one
	@RequestMapping("/courses/new")
	public String newLecture(@ModelAttribute("lecture")Lecture lecture, Principal p, Model m) {
		String username = p.getName();
		m.addAttribute ("currentUser", uServ.findByUsername(username));
		return "newCourse.jsp";
	}
	
	// To get (by POST method) the information the user submitted for the new course (in the newCourse.jsp form)
	@PostMapping ("/courses/new")
	public String createLecture(@Valid @ModelAttribute ("lecture") Lecture lecture, BindingResult result, Model m, HttpSession session, Principal p) {
		if (result.hasErrors()) {
			return "newCourse.jsp";
		} else {
			lecture.setUsers(uServ.findByUsername(p.getName()));
			lServ.createLecture(lecture);
			return "redirect:/courses";
		}
	}
	
	// To display the information of a specific course (selected from the ones shown in courses.jsp)
	@RequestMapping("/courses/{id}")
	public String showLecture(@PathVariable("id") Long id, Model m, Principal p, @ModelAttribute("signup") SignUp signup) {
		m.addAttribute("lecture", lServ.findById(id));
		m.addAttribute("signups", lServ.findAll());		
		String username = p.getName();
		m.addAttribute("currentUser", uServ.findByUsername(username));
		return "showCourse.jsp";
	}
	
	// To display the editCourse.jsp, when the user decides to update the information of a course in the courses.jsp
	@RequestMapping ("/courses/{id}/update")
	public String update(@ModelAttribute("lecture") Lecture lecture, Principal p,  Model m) {
		return "editCourse.jsp";
	}
	
	// Basically the same thing as the route above.
	@RequestMapping ("/courses/{id}/edit")
	public String editLecture(@PathVariable ("id") Long id, Model m, @ModelAttribute ("lecture") Lecture lecture, Principal p) {
		m.addAttribute("lecture", lServ.findById(id));
			return "editCourse.jsp";
	}
	
	// To gather the information submitted in editCourse.jsp's form.
	@PostMapping ("/courses/{id}/edit")
	public String updateCourse (@Valid @ModelAttribute ("lecture") Lecture lecture, BindingResult r, Model m, HttpSession session, Principal p, @PathVariable("id") Long id) {
		System.out.println("there are errors");
		if(r.hasErrors()) {
			return "editCourse.jsp";
		}
			lServ.updateLecture(lecture);  //This "lecture" is the same as the one in the form'sModel Attribute.
			return "redirect:/courses";
	}
	
	// To delete a course (the option is available in courses.jsp and editCourse.jsp)
	@RequestMapping ("/courses/{id}/delete")
	public String deleteLecture(@PathVariable("id") Long id, Principal p) {
		Lecture lecture = lServ.findById(id);
		lServ.deleteLecture(lecture);
		return "redirect:/courses";				
	}
	

	
}
