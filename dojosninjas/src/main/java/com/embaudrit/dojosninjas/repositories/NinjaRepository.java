package com.embaudrit.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.embaudrit.dojosninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{ //First attribute name, then data type

// 1. Find All
	List<Ninja> findAll();
	List<Ninja> findByDojo_id(Long id);
}
