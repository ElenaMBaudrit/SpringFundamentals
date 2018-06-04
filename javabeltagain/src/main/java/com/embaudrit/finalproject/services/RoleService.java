package com.embaudrit.finalproject.services;

import org.springframework.stereotype.Service;

import com.embaudrit.finalproject.repositories.RoleRepository;

@Service
public class RoleService {

	@SuppressWarnings("unused")
	private RoleRepository rRepo;
	public RoleService (RoleRepository rRepo) {
		this.rRepo = rRepo;
	}
}
