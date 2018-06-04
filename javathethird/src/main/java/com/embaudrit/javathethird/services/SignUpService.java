package com.embaudrit.javathethird.services;

import org.springframework.stereotype.Service;
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

}


//<form:form method="POST" action="/courses/${lecture.id}/signup" modelAttribute="signUp">
//	<form:hidden path="user" value = "${currentUserId}"/>
//<form:hidden path="lecture" value = "${lecture.id}"/>
//	<input type="submit" value="Add" />
//</form:form>

// @Valid @ModelAttribute("signUp") SignUp signUp, BindingResult result, 