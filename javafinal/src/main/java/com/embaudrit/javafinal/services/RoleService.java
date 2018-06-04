package com.embaudrit.javafinal.services;

import org.springframework.stereotype.Service;

import com.embaudrit.javafinal.repositories.RoleRepository;

@Service
public class RoleService {

	@SuppressWarnings("unused")
	private RoleRepository rRepo;
	public RoleService (RoleRepository rRepo) {
		this.rRepo = rRepo;
	}
}
