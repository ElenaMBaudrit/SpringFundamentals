package com.embaudrit.javathethird.controllers;

import java.security.Principal;
import java.util.List;

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
import com.embaudrit.javathethird.services.SignUpService;
import com.embaudrit.javathethird.services.UserService;

@Controller
public class LectureController {
	
	//Inject Services
	private LectureService lServ;
	private UserService uServ;
	private SignUpService suServ;
	
	public LectureController (LectureService lServ, UserService uServ, SignUpService suServ) {
		this.lServ = lServ;
		this.uServ = uServ;
		this.suServ = suServ;
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
	@RequestMapping(value = {"/courses/{id}"}) //Last
	public String showLecture(@PathVariable("id") Long id, Model m, Principal p, @ModelAttribute("signup") SignUp signup) {
		Lecture thisLecture = lServ.findById(id);
		m.addAttribute("lecture", thisLecture);
		m.addAttribute("signups", thisLecture.getSignUps());		
		String username = p.getName();
		m.addAttribute("currentUser", uServ.findByUsername(username));
		return "showCourse.jsp";
	}
	
	//To display the attendees for a course in a descending or ascending order.
	@RequestMapping(value= {"/courses/{id}/signup_{order}"})
	public String signUpOrder(@PathVariable("id") Long id, @PathVariable("order") String ord, Principal p, Model m, @ModelAttribute("signup") SignUp signup){
		String username = p.getName();
		Lecture lecture = lServ.findById(id); 
		
		// Will load the lecture (1) information on page.
		m.addAttribute("lecture", lServ.findById(id)); 
		System.out.println("Is this working?");
//		Will find and order all signups for the lecture above
		if (ord.equals("asc")) {
			m.addAttribute("signups", suServ.getLectureWhereId(id)); //Changed the "signups" for "lectures". Did not break. If it is changed to "lecture", it breaks 
		} 
		else if (ord.equals("desc" )) {
			m.addAttribute("signups", suServ.getLectureWhereIdDesc(id));//Changed the "signups" for "lectures". Did not break. "Lecture"? Breaks
		} else {
			m.addAttribute("signups", suServ.findById(id));
		}
		System.out.println("is this if being taken cared of?");
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
	
	
	
	
	
	
//	public String indexSignUp(@PathVariable("id") Long id, @PathVariable ("order") String order, Principal principal, Model m) {
//		String username = principal.getName();
//		//The new 2 lines (the ones from the exam with the likes)
//    	Lecture lecture = lServ.findById(id);
//    	@SuppressWarnings("unused")
//		List<SignUp> singups = lecture.getSignUps();
//    	//
//		m.addAttribute("lecture", lServ.findById(id));
//		m.addAttribute("currentUser", uServ.findByUsername(username));
//		m.addAttribute("currentUserId", uServ.findByUsername(username).getId());
		//THE FOLLOWING LINES WORK! JUST COMMENTED FOR FUNSIES
//		if (order.equals("asc")) {
//			m.addAttribute("signups", lServ.getLectureWhereId(id));
//		} else if (order.equals("desc" )) {
//			m.addAttribute("signups", lServ.getLectureWhereIdDesc(id));
//		} else {
//			m.addAttribute("signups", lServ.findById(id));
//		}
////		

	//findAllSignUpsforLectureId this is the neme for the function in the Service
}
