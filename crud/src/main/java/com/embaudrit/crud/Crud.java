package com.embaudrit.crud;

import javax.validation.constraints.Size;

//THIS THING SUPPOSED TO BE IN THE MODELS PACKAGE (that will be created for future assignments)

public class Crud {
// 1. Private attributes
	@Size (min = 3, max = 20) //This is the validation. Could be taken as "5."
	private String name;
	
	@Size (min = 3, max = 20) //Validation as well
	private String creator;
	
	@Size (min = 3, max = 20) //More!
	private String version;
	
// 2. Empty constructor
	public Crud() {
	}
	
// 3. Overloaded constructor
	public Crud(String name, String creator, String version) {
		this.name = name;
		this.creator = creator;
		this.version = version;
	}
	
// 4. Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String langName) {
		this.name = langName;
	}
	
	public String getCreator() {
		return creator;
	}
	public void setCreator (String creator) {
		this.creator = creator;
	}
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	

	
	
	
	
}
