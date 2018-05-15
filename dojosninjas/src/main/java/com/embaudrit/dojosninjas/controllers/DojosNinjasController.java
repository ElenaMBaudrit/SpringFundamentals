package com.embaudrit.dojosninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.embaudrit.dojosninjas.models.Dojo;
import com.embaudrit.dojosninjas.models.Ninja;
import com.embaudrit.dojosninjas.services.DojoService;
import com.embaudrit.dojosninjas.services.NinjaService;

@Controller
public class DojosNinjasController {
	
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojosNinjasController (DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	
	
	//This is to render the .jsp in the route requested in the assignment
	@RequestMapping("/")
	public String index() {
		return "redirect:/dojos/new";
	}
	
	//This renders the newDojo.jsp
	@RequestMapping("/dojos/new")
	public String newDojo (@ModelAttribute ("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	//This takes the info from the form in NewDojo.jsp
	@PostMapping("/dojos/add_new")
	public String createNewDojo(@ModelAttribute ("dojo") Dojo dojo, BindingResult result) {
		dojoService.saveDojo(dojo);
		return "redirect:/ninjas/new";
	}
	
	//To show the info submitted in the newDojo page. Apparently, it must be in the drop down menu
	@RequestMapping("/ninjas/new")
	public String showNewDojo(@ModelAttribute ("ninja") Ninja ninja, Model m) {
		m.addAttribute("dojos", dojoService.findAllDojos());
		return "newNinja.jsp";
	}
	
	//To gather the information from the newNinja.jsp's form
	@PostMapping("/ninjas/add_new")
	public String addNewNinja(@ModelAttribute ("ninja") Ninja ninja, BindingResult result, @RequestParam("dojo") Long id) {
		ninjaService.saveNinja(ninja);
		return "redirect:/ninjas/"+id;
	}
	
	//Display the locationNinjas, where the Ninjas in a specific Dojo are displayed
	@RequestMapping("/ninjas/{id}")
	public String createNewNinja(@PathVariable ("id") Long id, Model m) {
		m.addAttribute("ninjas", ninjaService.findByDojo_id(id));
		return "locationNinjas.jsp";
	}

}
