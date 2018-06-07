package com.embaudrit.javathethird.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.embaudrit.javathethird.models.Lecture;
import com.embaudrit.javathethird.models.SignUp;
import com.embaudrit.javathethird.repositories.SignUpRepository;

@Service
public class SignUpService {
	private SignUpRepository suRepo;
	public SignUpService (SignUpRepository suRepo) {
		this.suRepo = suRepo;
	}
	
	public void addSignUp (SignUp signUp) {
		suRepo.save(signUp);
	}
	
	public SignUp findById(Long id) {
		return suRepo.findById(id).get();
	}
	
	//Find Signups
	public List<SignUp> findAll(){
		return suRepo.findAll();
	}
	
	//Display signed up users in Ascending order
	public List<SignUp> findAllAsc(){
		return suRepo.findAllAsc();
	}
	
	//Display signed up users in descending order
	public List<SignUp> findAllDesc(){
		return suRepo.findAllDesc();
	}

	//Remove sign up
	public void removeSignUp (SignUp signUp) {
		suRepo.delete(signUp);
	}
	
	//Display signed up users in Ascending order
	public List<SignUp> getLectureWhereId(Long id){
		return suRepo.getLectureWhereId(id);
	}
	
	//Display signed up users in descending order
	public List<SignUp> getLectureWhereIdDesc(Long id){
		return suRepo.getLectureWhereIdDesc(id);
	}

}


//<form:form method="POST" action="/courses/${lecture.id}/signup" modelAttribute="signUp">
//	<form:hidden path="user" value = "${currentUserId}"/>
//<form:hidden path="lecture" value = "${lecture.id}"/>
//	<input type="submit" value="Add" />
//</form:form>

// @Valid @ModelAttribute("signUp") SignUp signUp, BindingResult result, 
