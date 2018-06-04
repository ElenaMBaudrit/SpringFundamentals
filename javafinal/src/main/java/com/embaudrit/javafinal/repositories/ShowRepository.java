package com.embaudrit.javafinal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.embaudrit.javafinal.models.Show;

@Repository
public interface ShowRepository extends CrudRepository <Show, Long> {
	List<Show> findAll();

//	@Query("SELECT i FROM Idea i JOIN i.liked l ORDER BY COUNT(l) ASC")
//	List<Show> findAllByOrderByCountAsc();

}
