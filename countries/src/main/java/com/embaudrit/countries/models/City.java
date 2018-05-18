package com.embaudrit.countries.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
@Table (name = "cities")
public class City {
// 1. Private Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Size(max = 35)
	private String name;
	
	@Column
	@Size(max = 3)
	private String country_code;
	
	@Column
	@Size(max =20)
	private String district;
	
	@Column
	@Digits(integer = 11, fraction = 0)
	private Integer population;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	private Country country;
		
// 2. Empty constructor
	public City() {
		
	}
	
// 3. Overloaded constructor
	public City(@Size(max = 35) String name, @Size(max = 3) String country_code, @Size(max = 20) String district,
			@Digits(integer = 11, fraction = 0) Integer population) {
		this.name = name;
		this.country_code = country_code;
		this.district = district;
		this.population = population;
	}

	
// 4. Getters and Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
