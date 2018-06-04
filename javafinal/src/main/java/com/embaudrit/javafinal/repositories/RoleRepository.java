package com.embaudrit.javafinal.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.embaudrit.javafinal.models.Role;

@Repository
public interface RoleRepository extends CrudRepository <Role,Long> {
	public List <Role> findAll();
	
	List<Role> findByName(String string);

}