package com.embaudrit.diverslicense.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.embaudrit.driverslicense.model.License;
import com.embaudrit.driverslicense.model.Person;
import com.embaudrit.driverslicense.service.LicenseService;
import com.embaudrit.driverslicense.service.PersonService;

@Controller
public class LicenseController {
	private final LicenseService licenseService;
	private final PersonService personService;
	
	public LicenseController (LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}

	//To redirect to the correct URL in order to display the index page
	@RequestMapping("/")
	public String redirectToIndex() {
		System.out.println("Churuquitos");
		return "index.jsp";
	}
	
	// To display the "new user" form page
	@RequestMapping("/person/new")
	public String index() {
		System.out.println("Churuquitos2");
		return "index.jsp";
	}
	
	// To gather the /information from the New Person's form
	@PostMapping("/person/add_new_person") //This must be changed to POST
	public String addNewPerson(@ModelAttribute ("person") Person person, BindingResult result) {
		return "redirect:/person/create_new_person";
	}
	
	//To display the information in the License's form page
	@RequestMapping("/licenses/new")
	public String newLicenseForm(@ModelAttribute ("license") License license, BindingResult result, Model model) {
		return "new_license_form.jsp";
	}

	// To gather the information from the New License form and create the new license
	@PostMapping("/person/add_new_license") //This must be changed to POST
	public String addNewLicense(@ModelAttribute ("license") License license, BindingResult result) {
		return "redirect:/person/create_new_license";
	}
	
	// To display the newly created license
	@RequestMapping("/person/{id}")
	public String newLicenseDisplay(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", personService.findPerson(id));
		return "new_license.jsp";
	}

}




