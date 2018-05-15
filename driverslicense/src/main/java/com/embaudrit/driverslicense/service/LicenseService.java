package com.embaudrit.driverslicense.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.embaudrit.driverslicense.model.License;
import com.embaudrit.driverslicense.repository.LicenseRepository;

@Service
public class LicenseService {
	
	private final LicenseRepository licenseRepository;
	public LicenseService (LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public void addLicense(License license) {
		licenseRepository.save(license);
	}

	public List<License> allLicenses(){
		return licenseRepository.findAll();
	}
}
