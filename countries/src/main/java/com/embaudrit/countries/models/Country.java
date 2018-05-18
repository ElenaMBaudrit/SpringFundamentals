package com.embaudrit.countries.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
@Table(name = "countries")
public class Country {

// 1. Private Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Size(max = 3)
	private String code;
	
	@Column
	@Size(max = 52)
	private String name;
	
	@Column
	private String continent;
	
	@Column
	@Size(max = 26)
	private String region;
	
	@Column
	@Digits(integer = 10, fraction = 2)
	private double surface_area;
	
	@Column
	@Digits(integer = 6, fraction = 0)
	private short indep_year;
	
	@Column
	@Digits(integer = 11, fraction = 0)
	private Integer population;
	
	@Column
	@Digits(integer = 3, fraction = 1)
	private double life_expectancy;
	
	@Column
	@Digits(integer = 10, fraction = 2)
	private double gnp;
	
	@Column
	@Digits(integer = 10, fraction = 2)
	private double gnp_old;
	
	@Column
	@Size(max = 45)
	private String local_name;
	
	@Column
	@Size(max = 45)
	private String government_form;
	
	@Column
	@Size(max = 60)
	private String head_of_state;
	
	@Column
	@Digits(integer = 11, fraction = 0)
	private Integer capital;
	
	@Column
	@Size(max = 2)
	private String code2;
	
	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
	private List<Language> languages;
	
	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
	private List<City> cities;
	
// 2. Empty constructor
	public Country() {
		
	}
	
// 3. Overloaded constructor
	public Country(@Size(max = 3) String code, @Size(max = 52) String name, String continent,
			@Size(max = 26) String region, @Digits(integer = 10, fraction = 2) double surface_area,
			@Digits(integer = 6, fraction = 0) short indep_year, @Digits(integer = 11, fraction = 0) Integer population,
			@Digits(integer = 3, fraction = 1) double life_expectancy, @Digits(integer = 10, fraction = 2) double gnp,
			@Digits(integer = 10, fraction = 2) double gnp_old, @Size(max = 45) String local_name,
			@Size(max = 45) String government_form, @Size(max = 60) String head_of_state,
			@Digits(integer = 11, fraction = 0) Integer capital, @Size(max = 2) String code2) {
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.region = region;
		this.surface_area = surface_area;
		this.indep_year = indep_year;
		this.population = population;
		this.life_expectancy = life_expectancy;
		this.gnp = gnp;
		this.gnp_old = gnp_old;
		this.local_name = local_name;
		this.government_form = government_form;
		this.head_of_state = head_of_state;
		this.capital = capital;
		this.code2 = code2;
	}

// 4. Getters and Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public double getSurface_area() {
		return surface_area;
	}

	public void setSurface_area(double surface_area) {
		this.surface_area = surface_area;
	}

	public short getIndep_year() {
		return indep_year;
	}

	public void setIndep_year(short indep_year) {
		this.indep_year = indep_year;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public double getLife_expectancy() {
		return life_expectancy;
	}

	public void setLife_expectancy(double life_expectancy) {
		this.life_expectancy = life_expectancy;
	}

	public double getGnp() {
		return gnp;
	}

	public void setGnp(double gnp) {
		this.gnp = gnp;
	}

	public double getGnp_old() {
		return gnp_old;
	}

	public void setGnp_old(double gnp_old) {
		this.gnp_old = gnp_old;
	}

	public String getLocal_name() {
		return local_name;
	}

	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}

	public String getGovernment_form() {
		return government_form;
	}

	public void setGovernment_form(String government_form) {
		this.government_form = government_form;
	}

	public String getHead_of_state() {
		return head_of_state;
	}

	public void setHead_of_state(String head_of_state) {
		this.head_of_state = head_of_state;
	}

	public Integer getCapital() {
		return capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
}
