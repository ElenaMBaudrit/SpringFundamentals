package com.embaudrit.javathethird.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.embaudrit.javathethird.models.Role;

@Repository
public interface RoleRepository extends CrudRepository <Role,Long> {
	public List <Role> findAll();
	
	List<Role> findByName(String string);

}