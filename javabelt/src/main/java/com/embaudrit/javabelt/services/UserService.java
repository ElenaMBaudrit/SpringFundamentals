package com.embaudrit.javabelt.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.embaudrit.javabelt.models.Role;
import com.embaudrit.javabelt.models.User;
import com.embaudrit.javabelt.repositories.RoleRepository;
import com.embaudrit.javabelt.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    public List<User> allUsers() {
    	return userRepository.findAll();
    }
    
    public Role findRoleByName(String role){
    	return roleRepository.findByName(role).get(0);
    }
 
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
     
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }    
    
    public void makeAdmin(User user) {
		user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
	    userRepository.save(user);
    }
    
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }
    
    public void deleteUserById(Long id) {
    	userRepository.deleteById(id);
    }
    
    public void save(User user) {
    	userRepository.save(user);
    }
}