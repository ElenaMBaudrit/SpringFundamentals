package com.embaudrit.javathethird.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.embaudrit.javathethird.models.Lecture;
import com.embaudrit.javathethird.models.SignUp;

@Repository
public interface SignUpRepository extends CrudRepository<SignUp, Long>{
	List<SignUp> findAll();
		
	//This is for sorting the attendees by the sign up date (Ascendent, the default one)
	@Query("SELECT s FROM SignUp s ORDER BY (s.createdAt)") 
	List<SignUp> findAllAsc();
	
	//This is for sorting the attendees by the sign up date (Descendent)
	@Query("SELECT s FROM SignUp s ORDER BY (s.createdAt) DESC") 
	List<SignUp> findAllDesc();
	
//	//This is for sorting the attendees by the sign up date (Ascendent, the default one)
	@Query("SELECT s FROM SignUp s WHERE s.lecture.id=?1 ORDER BY (s.createdAt)") // adding JOIN Lecture l WHERE l.id=?1
	List<SignUp> getLectureWhereId(Long id);
	
	//This is for sorting the attendees by the sign up date (Descendent)
	@Query("SELECT s FROM SignUp s WHERE s.lecture.id=?1 ORDER BY (s.createdAt) DESC") 
	List<SignUp> getLectureWhereIdDesc(Long id);
//	
	
}


