package com.embaudrit.dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.embaudrit.dojosninjas.models.Dojo;
import com.embaudrit.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
// 1. Inject Repository
	private DojoRepository dojoRepository;
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
// 2. Find all and save
	public List<Dojo> findAllDojos(){
		return dojoRepository.findAll();
	}
	public void saveDojo (Dojo dojo) {
		dojoRepository.save(dojo);
	}

}
