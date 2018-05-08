package com.embaudrit.learningplatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LearningPlatformControllers {
	
	@RequestMapping ("/")
	public String index() {
		return "index.jsp";
	}
	
    @RequestMapping("/m/{chapter}/0483/{assignmentNumber}")
    public String assignment(@PathVariable("chapter") String chapter, @PathVariable("assignmentNumber") String assignmentNumber, Model model) {
    	switch (assignmentNumber) {
    	case "0345":{
    		model.addAttribute("content","Coding Forms");
    	}break;
    	
    	case "2342":{
    		model.addAttribute("content", "Fortran to Binary");
		}break;
    	}
    	return "assignments.jsp";
    }
    
    @RequestMapping("m/{chapter}/0553/{lessonNumber}")
    public String lesson(@PathVariable("chapter") String chapter, @PathVariable("lessonNumber") String lessonNumber, Model model) {
    	switch(lessonNumber) {
    	case "0733":{
    		model.addAttribute("content", "Setting up your servers");
    	}break;
    	case "0342":{
    		model.addAttribute("content", "Punch Cards");
    	}break;
    	case "0348":{
    		model.addAttribute("Advanced Fortran Intro");
    	}break;
    	}
    	return "lessons.jsp";
	}
}

