package com.embaudrit.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.embaudrit.lookify.models.Lookify;
import com.embaudrit.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	private LookifyRepository lookifyRepository;
	public LookifyService (LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	
	public List<Lookify> allSongs () { //This must be called the same as the class defined in the models, therefore, I'll have a bunch of "lookifies"
		//The allSongs is for my sole reference, and for consistency' sake
		return lookifyRepository.findAll();
	}
	
	public void addSong (Lookify song) {//the lookify here comes from the class name again. the object's name will be what has been added: "songs"
		lookifyRepository.save(song);
	}
	
	public void destroySong(Long id) {
		lookifyRepository.deleteById(id);
	}
	
	public Lookify findSongById (Long id) {
		Optional <Lookify> optionalSong = lookifyRepository.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		}
		else {
			return null;
		}
	}
	
	public List<Lookify> findByArtist (String artist) {
		return lookifyRepository.findByArtistContaining(artist);
	}
	
	public List<Lookify> findTopTen () {
		return lookifyRepository.findTop10ByOrderByRatingDesc();
	}
}
