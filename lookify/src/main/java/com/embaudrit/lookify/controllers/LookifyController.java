package com.embaudrit.lookify.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.embaudrit.lookify.models.Lookify;
import com.embaudrit.lookify.services.LookifyService;

@Controller
public class LookifyController {

	private final LookifyService lookifyService;
	public LookifyController (LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	
	// Landing Page
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	//Dashboard (rendering)
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("song", lookifyService.allSongs());
		return "dashboard.jsp";
	}
	
//	@RequestMapping("/{id}")
//	public String findSongById (Model model, @ModelAttribute("song") Lookify song) {
//		List<Lookify> songs = lookifyService.allSongs();
//		model.addAttribute("song", song);
//		return "index.jsp";
//	}
	
	
	// Show the song info
	@RequestMapping("/songs/{id}") 
	public String songs(@PathVariable("id")Long id, Model model) {
		model.addAttribute("song", lookifyService.findSongById(id));
		return "songs.jsp";
	}
	
	
	// Show artist information
	@RequestMapping("/search/{artist}") //This must have the validation for the search
	public String showArtist(@PathVariable ("artist")String artist, Model model) {
		model.addAttribute("song", lookifyService.findByArtist(artist));
		return "artist.jsp";
	}
	
	@RequestMapping("/search")
	public String searchArtist(@RequestParam("artist") String artist) {
		return "redirect:/search/"+artist; // in this case, "artist" is the variable I'm calling, not the id or name of the actual artist (as it was in the one above)
	}
	
	
	@RequestMapping("/top_Ten")
	public String top_ten(Model model) {
		model.addAttribute("song", lookifyService.findTopTen());
		return "top_ten.jsp";
	}
	
	@RequestMapping("/new_song" )
	public String new_song(@ModelAttribute ("song") Lookify song) {
		return "new_song.jsp";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String destroySong(@PathVariable("id") Long id) {
		lookifyService.destroySong(id);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/add_new_song")
	public String createSong(@Valid @ModelAttribute ("song") Lookify song, BindingResult result) {
		if (result.hasErrors()) {
			return "new_song.jsp";
		}
		else {
			lookifyService.addSong(song);
			return "redirect:/dashboard";
		}
	}

	

}
