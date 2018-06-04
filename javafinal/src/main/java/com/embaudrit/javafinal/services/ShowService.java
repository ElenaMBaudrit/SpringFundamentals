package com.embaudrit.javafinal.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.embaudrit.javafinal.models.Show;
import com.embaudrit.javafinal.repositories.ShowRepository;

@Service
public class ShowService {

	private ShowRepository showRepository;
	
	public ShowService (ShowRepository showRepository) {
		this.showRepository = showRepository;
	}

	public void createShow(@Valid Show show) {
		showRepository.save(show);
		
	}

	public List<Show> findAll() {
		return showRepository.findAll();
	}

	public Show findById(Long id) {
		return showRepository.findById(id).get();
	}

	public void updateShow(Show show) {
		showRepository.save(show);
		
	}

	public void deleteShow(Show show) {
		showRepository.delete(show);
		
	}

//	public List<Show> findAllByOrderByCountAsc() {
//		return showRepository.findAllByOrderByCountAsc();
//	}

}