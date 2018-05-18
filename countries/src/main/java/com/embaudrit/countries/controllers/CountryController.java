package com.embaudrit.countries.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.embaudrit.countries.services.ApiService;

@Controller
public class CountryController {
	
	private final ApiService apiService;
	public CountryController (ApiService apiService) {
		this.apiService = apiService;
	}
	
	@RequestMapping("/")
	public String index () {
//		serv.findCountriesSlovene();
//		System.out.println("-------------------------------------");
//		serv.showCitiesPerCountry();
//		System.out.println("-------------------------------------");
//		serv.mexicanCitiesOver500k();
//		System.out.println("-------------------------------------");
//		serv.languagesPerCountryOver89();
//		System.out.println("-------------------------------------");
//		serv.countriesSmaller500PopulationOver100k();
//		System.out.println("-------------------------------------");
//		serv.countriesWithConstitutionalMonarchy();
//		System.out.println("-------------------------------------");
//		serv.citiesBuenosairesOver500k();
		System.out.println("-------------------------------------");
		apiService.citiesPerRegion();
		System.out.println("-------------------------------------");
		return "index";
	}
}