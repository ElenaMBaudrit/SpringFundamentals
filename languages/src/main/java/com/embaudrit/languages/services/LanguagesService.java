package com.embaudrit.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.embaudrit.languages.Languages;
import com.embaudrit.languages.repositories.LanguagesRepository;

@Service
public class LanguagesService {

	private LanguagesRepository languagesRepository;
	public LanguagesService (LanguagesRepository languagesRepository) {
		this.languagesRepository = languagesRepository;
	}
	
	
	public List<Languages> allLanguages (){
		return languagesRepository.findAll(); //I guess this is not yet in the LanguagesController.java file
	}

	public void addLanguages (Languages languages) {
		languagesRepository.save(languages);
	}
	
	public void destroyLanguages(Long id) {
		languagesRepository.deleteById(id);
	}
	

	
	
	
//	public Languages findEditLanguages(int index) {
//		if (index < languages.size()) {
//			return languages.get(index);
//		}
//		else {
//			return null;
//		}
//	}
//	
//	public Languages findShowLanguage(int index) {
//		if (index < languages.size()) {
//			return languages.get(index);
//		}
//		else {
//			return null;
//		}
//	}
//	
//	
//	public void updateLanguage(int id, Languages language) {
//		if (id < languages.size()) {
//			languages.set(id, language);
//		}
//	}
//	
//	public void destroyLanguage(int id) {
//		if (id < languages.size()) {
//			languages.remove(id);
//		}
//	}
	
}
