package com.embaudrit.dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.embaudrit.dojosninjas.models.Ninja;
import com.embaudrit.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
// 1. Inject Repository
	private NinjaRepository ninjaRepository;
	public NinjaService (NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
// 2. Find all and save
	public List<Ninja> findAllNinjas(){
		return ninjaRepository.findAll();
	}
	public void saveNinja (Ninja ninja) {
		ninjaRepository.save(ninja);
	}

	public List<Ninja> findByDojo_id(Long id) {
		return ninjaRepository.findByDojo_id(id);
	}
}
