package com.embaudrit.logreg.repositories;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.embaudrit.logreg.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String username);
    
	@Modifying
	@Transactional
	@Query ("update User u set u.last_sign_in = ?1 WHERE u.id = ?2")
	void setLast_sign_in(Date last_sign_in, Long id);
    
}
