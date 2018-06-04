package com.embaudrit.javathethird.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.embaudrit.javathethird.models.Lecture;

@Repository
public interface LectureRepository extends CrudRepository <Lecture, Long>{
	List<Lecture> findAll();
	
	Optional<Lecture> findById(Long id); //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories

}
