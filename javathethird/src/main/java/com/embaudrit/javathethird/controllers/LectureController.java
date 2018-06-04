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
	
	@RequestMapping("/courses/new")
	public String newLecture(@ModelAttribute("lecture")Lecture lecture, Principal p, Model m) {
		String username = p.getName();
		m.addAttribute ("currentUser", uServ.findByUsername(username));
		return "newCourse.jsp";
	}
	
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
	
	@RequestMapping("/courses/{id}")
	public String showLecture(@PathVariable("id") Long id, Model m, Principal p, @ModelAttribute("signup") SignUp signup) {
		m.addAttribute("lecture", lServ.findById(id));
		String username = p.getName();
		m.addAttribute("currentUser", uServ.findByUsername(username));
		return "showCourse.jsp";
	}
	
	@RequestMapping ("/courses/{id}/update")
	public String update(@ModelAttribute("lecture") Lecture lecture, Principal p,  Model m) {
		return "editCourse.jsp";
	}
	
	@RequestMapping ("/courses/{id}/edit")
	public String editLecture(@PathVariable ("id") Long id, Model m, @ModelAttribute ("lecture") Lecture lecture, Principal p) {
		m.addAttribute("lecture", lServ.findById(id));
			return "editCourse.jsp";
	}
	
	@PostMapping ("/courses/{id}/edit")
	public String updateCourse (@Valid @ModelAttribute ("lecture") Lecture lecture, BindingResult r, Model m, HttpSession session, Principal p, @PathVariable("id") Long id) {
		System.out.println("there are errors");
		if(r.hasErrors()) {
			return "editCourse.jsp";
		}
			lServ.updateLecture(lecture);  //This "lecture" is the same as the one in the form'sModel Attribute.
			return "redirect:/courses";
	}
	
	@RequestMapping ("/courses/{id}/delete")
	public String deleteLecture(@PathVariable("id") Long id, Principal p) {
		Lecture lecture = lServ.findById(id);
		lServ.deleteLecture(lecture);
		return "redirect:/courses";				
	}
	
	
	
}
