package com.embaudrit.javafinal.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.embaudrit.javafinal.models.User;
import com.embaudrit.javafinal.repositories.RoleRepository;
import com.embaudrit.javafinal.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository uRepo;
	private RoleRepository rRepo;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService (UserRepository uRepo, RoleRepository rRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.uRepo = uRepo;
		this.rRepo = rRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public List <User> findUserByRole(String role) {
		return uRepo.findByRole(role);
	}

	public void saveUserWithAdminRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(rRepo.findByName("ROLE_ADMIN"));
		uRepo.save(user);
	}
	
	public void saveUserWithUserRole (User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(rRepo.findByName("ROLE_USER"));
		uRepo.save(user);
	}
	
	public User findByUsername(String email) {
		return uRepo.findByEmail(email);
	}
}
