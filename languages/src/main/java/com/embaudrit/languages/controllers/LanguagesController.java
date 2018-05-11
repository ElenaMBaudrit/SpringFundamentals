package com.embaudrit.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.embaudrit.languages.Languages;
import com.embaudrit.languages.services.LanguagesService;

@Controller
public class LanguagesController {
private final LanguagesService languagesService;
	
	public LanguagesController (LanguagesService languagesService) {
		this.languagesService = languagesService;
	}
	
	@RequestMapping("/")
	//Put the model attribute as a parameter HERE (the line below)
	public String index (Model model, @ModelAttribute("language") Languages language) {   
		List<Languages> languages = languagesService.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@RequestMapping("/{id}")
	public String findLanguagesByIndex (@PathVariable("id") Long id, Model model) {
		model.addAttribute("languages", languagesService.findLanguagesById(id));
		return "index.jsp";
	}
	
	@PostMapping("/add_lang") 
	public String newLanguages(@Valid @ModelAttribute("language") Languages languages, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		}
		else {
			languagesService.addLanguages(languages);
			return "redirect:/";
		}
	}
	
	@RequestMapping (value = "/delete/{id}")
	public String destroyLanguages(@PathVariable("id") Long id) {
		languagesService.destroyLanguages(id);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public String editLanguages(@PathVariable ("id") Long id, Model model, @ModelAttribute("language") Languages languages) {
		model.addAttribute("languages", languagesService.findLanguagesById(id));
		return "edit.jsp";
	}
	
	@PostMapping("/edit/{id}")
	//the "language" must match the one in the form (for submission)
	public String updateLanguages (@Valid @ModelAttribute("language") Languages languages, BindingResult result, @PathVariable ("id") Long id) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			languagesService.updateLanguages(languages);
			return "redirect:/";
		}
	}

}
