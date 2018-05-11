package com.embaudrit.languages.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
//		List<Languages> languages = languagesService.allLanguages(); //This "allLanguages" comes from the CrudService.java file
//		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@RequestMapping (value = "/delete/{id}")
	public String destroyLanguages(@PathVariable("id") Long id) {
		languagesService.destroyLanguages(id);
		return "redirect:/";
	}
	
	
//	@PostMapping("/new") //This was called "/process" before. Remember to change it on the .jsp
//	// Why "@PostMapping"? Not quite sure at this time.
//	public String newLanguage(@Valid @ModelAttribute("language") Languages language, BindingResult result) {
//		if (result.hasErrors()) {
//			return "index.jsp";
//		}
//		else {
//			languagesService.addLanguages(language);
//			return "redirect:/";
//		}
//	}
//	
//	@RequestMapping("/edit/{index}")
//	public String editLanguage(Model model, @PathVariable("index") int index) {
////		Languages language = languagesService.findEditLanguage(index);
////		model.addAttribute("language", language);
////		model.addAttribute("index", index);
//		return "edit.jsp";
//	}
	
//	@PostMapping(path = "/edited/{index}")
//	public String editedLanguage (@Valid @ModelAttribute("language") Languages language, @PathVariable("index") int index) {
//		languagesService.updateLanguage(index, language);
//		return "redirect:/";
//	}
	
//	@RequestMapping("/languages/{index}")
//	public String showLanguage(Model model, @PathVariable("index") int index) {
//		Languages languages = languagesService.findShowLanguage(index);
//		model.addAttribute("language", language);
//		model.addAttribute("index", index);
//		return "languages.jsp";
//	}
//	

//}

}
