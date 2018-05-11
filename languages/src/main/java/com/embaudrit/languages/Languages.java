package com.embaudrit.languages;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Languages {

// 1. Private attributes
	
	@Id //Copy this, believe in it. Don't change it.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column //This is the first column of the table that will be created in MySQL
	@Size (min = 3, max = 20) //This is the validation. Could be taken as "5."
	private String name;
	
	@Column
	@Size (min = 3, max = 20) //Validation as well
	private String creator;
	
	@Column
	@Size (min = 1, max = 20) //More!
	private String version;
	
	@Column (updatable = false) //This is for the "created_at" in MySQL table
	@DateTimeFormat (pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	
	@Column // This is for the "updated_at" in MySQL table. It is, by definition, updatable.
	@DateTimeFormat (pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updateAt;
	
// 2. Empty constructor
	public Languages() {
	}	
	
// 3. Overloaded constructor
	public Languages(String name, String creator, String version) {
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
	//
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	//
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	//
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	//
	public String getCreator() {
		return creator;
	}
	public void setCreator (String creator) {
		this.creator = creator;
	}
	//
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}	
	//
	
	@PrePersist //"To always do something before saving an object for the first time"
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate// "To do something before we save every time"
	protected void onUpdate() {
		this.updateAt = new Date();
	}
}
