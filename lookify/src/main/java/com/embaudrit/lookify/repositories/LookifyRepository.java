package com.embaudrit.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.embaudrit.lookify.models.Lookify;

@Repository
public interface LookifyRepository extends CrudRepository <Lookify, Long> {
	List<Lookify> findAll();
	List<Lookify> findByArtistContaining(String artist);
	List<Lookify> findTop10ByOrderByRatingDesc();
}
