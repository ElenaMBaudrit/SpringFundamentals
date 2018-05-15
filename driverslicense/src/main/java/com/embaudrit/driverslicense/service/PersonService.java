package com.embaudrit.driverslicense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.embaudrit.driverslicense.model.Person;
import com.embaudrit.driverslicense.repository.PersonRepository;

@Service
public class PersonService {
	
	private final PersonRepository personRepository;
	public PersonService (PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> allPersons(){
		return personRepository.findAll();
	}
	public void addPerson(Person person) {
		personRepository.save(person);
	}
	
	public Person findPerson (Long id) {
		Optional<Person> person = personRepository.findById(id);
		return person.get();
	}
}

