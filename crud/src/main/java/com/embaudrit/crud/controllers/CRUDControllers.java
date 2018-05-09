package com.embaudrit.crud.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.embaudrit.crud.Crud;
import com.embaudrit.crud.services.CrudService;

@Controller
public class CRUDControllers {
	private final CrudService crudService;
	
	public CRUDControllers (CrudService crudService) {
		this.crudService = crudService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Crud> languages = crudService.allLanguages(); //This "allLanguages" comes from the CrudService.java file
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@PostMapping("/new") //This was called "/process" before. Remember to change it on the .jsp
	// Why "@PostMapping"? Not quite sure at this time.
	public String newLanguage(@Valid @ModelAttribute("language") Crud language, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		}
		else {
			return "redirect:/edit/{index}";
		}
	}
	
	@RequestMapping("/edit/{index}")
	public String editLanguage(Model model, @PathVariable("index") int index) {
		Crud language = crudService.findEditLanguage(index);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	@RequestMapping("/languages/{index}")
	public String showLanguage(Model model, @PathVariable("index") int index) {
		Crud language = crudService.findShowLanguage(index);
		model.addAttribute("language", language);
		return "languages.jsp";
	}

}
