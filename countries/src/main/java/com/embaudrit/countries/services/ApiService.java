package com.embaudrit.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.embaudrit.countries.repositories.CountryRepository;

@Service
public class ApiService {
	
	private final CountryRepository countryRepository;
	public ApiService (CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	public void findCountriesSlovene() {
		List <Object[]> table = countryRepository.findCountriesSlovene();
		for (Object[] row : table) {
			String c = (String) row[0];
			String l = (String) row[1];
			Double p = (Double) row[2];
			System.out.println(c);
			System.out.println(l);
			System.out.println(p);
		}
	}
	
	public void showCitiesPerCountry() {
		List <Object[]> table = countryRepository.showCitiesPerCountry();
		for (Object[] row : table) {
			String c = (String) row[0];
			Long n = (long) row[1];
			System.out.println(c);
			System.out.println(n);			
		}
	}
	
	public void mexicanCitiesOver500k() {
		List<String> table = countryRepository.mexicanCitiesOver500k();
		for (String row : table) {
			System.out.println(row);			
		}
	}
	
	public void languagesPerCountryOver89() {
		List <Object[]> table = countryRepository.languagesPerCountryOver89();
		for (Object[] row : table) {
			String c = (String) row[0];
			String l = (String) row[1];
			Double p = (Double) row[2];
			System.out.println(l);
			System.out.println(c);
			System.out.println(p);
		}
	}

	public void countriesSmaller500PopulationOver100k() {
		List <Object[]> table = countryRepository.countriesSmaller500PopulationOver100k();
		for (Object[] row : table) {
			System.out.println(row[0]);
			System.out.println(row[1]);
			System.out.println(row[2]);
		}
	}
	
	public void countriesWithConstitutionalMonarchy() {
		List <String> x = countryRepository.countriesWithConstitutionalMonarchy();
		for (String s : x) {
			System.out.println(s);
		}
	}
	
	public void citiesBuenosairesOver500k() {
		List <Object[]> table = countryRepository.citiesBuenosairesOver500k();
		for (Object[] row : table) {
			System.out.println(row[0]);
			System.out.println(row[1]);
			System.out.println(row[2]);
			System.out.println(row[3]);
		}
	}
	
	public void citiesPerRegion() {
		List <Object[]> table = countryRepository.citiesPerRegion();
		for (Object[] row : table) {
			System.out.println(row[0]);
			System.out.println(row[1]);
		}
	}
}
