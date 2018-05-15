package com.embaudrit.driverslicense.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.embaudrit.driverslicense.model.Person;

@Repository
public interface PersonRepository extends CrudRepository <Person, Long> {
	List<Person> findAll();
}
