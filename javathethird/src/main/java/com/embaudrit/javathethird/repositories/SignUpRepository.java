package com.embaudrit.javathethird.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.embaudrit.javathethird.models.SignUp;


@Repository
public interface SignUpRepository extends CrudRepository<SignUp, Long>{
	List<SignUp> findAll();
	

}
