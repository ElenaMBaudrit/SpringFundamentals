package com.embaudrit.crud.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.embaudrit.crud.Crud;

//Well, apparently, naming the project "Crud" was NOT a good idea. Next time, BE CONSISTENT!

@Service
public class CrudService {
	List<Crud> languages = new ArrayList<Crud>(Arrays.asList(
			new Crud("Java", "Oskar Myer", "1.8"),
			new Crud("HTML", "Betty Crocker", "5"),
			new Crud("Python", "C. Boyardee", "8")));
	
	public List<Crud> allLanguages (){
		return languages;
	}
	
	public Crud findEditLanguage(int index) {
		if (index < languages.size()) {
			return languages.get(index);
		}
		else {
			return null;
		}
	}
	
	public Crud findShowLanguage(int index) {
		if (index < languages.size()) {
			return languages.get(index);
		}
		else {
			return null;
		}
	}
	
	public void addLanguage (Crud language) {
		languages.add(language);
	}
}
