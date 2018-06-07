package com.embaudrit.javathethird.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.embaudrit.javathethird.models.Lecture;
import com.embaudrit.javathethird.models.SignUp;

@Repository
public interface LectureRepository extends CrudRepository <Lecture, Long>{
	List<Lecture> findAll();
	
	Optional<Lecture> findById(Long id); //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories

	@Query("SELECT l FROM Lecture l ORDER BY (l.signUps.size)") // With "GROUP BY" did not work...Well, it worked weird
	List<Lecture> findAllAsc();
	
	@Query("SELECT l FROM Lecture l ORDER BY (l.signUps.size) DESC") // With "GROUP BY" did not work...Well, it worked weird
	List<Lecture> findAllDesc();
}
