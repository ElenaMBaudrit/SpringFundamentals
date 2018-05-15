package com.embaudrit.driverslicense.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.embaudrit.driverslicense.model.License;

@Repository
public interface LicenseRepository extends CrudRepository <License, Long> {
	List<License> findAll();
}
