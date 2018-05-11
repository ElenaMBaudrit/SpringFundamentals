package com.embaudrit.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.embaudrit.languages.Languages;

@Repository
public interface LanguagesRepository extends CrudRepository<Languages, Long>{

	List<Languages> findAll();
	

}
