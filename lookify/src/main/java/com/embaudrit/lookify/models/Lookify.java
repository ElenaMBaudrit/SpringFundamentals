package com.embaudrit.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Lookify {
	
//	1. Private attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Size(min = 5, max = 100)
	private String  title;
	
	@Column
	@Size (min = 5, max = 100)
	private String artist;
	
	@Column
	@Min(1)
	@Max(10)
	private int rating;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	
//	2. Empty constructor
	public Lookify() {
		
	}
	
//	3. Overloaded constructor
	public Lookify (String title, String artist, int rating) {
	this.title = title;
	this.artist = artist;
	this.rating = rating;
	}
	
//	4. Getters and Setters

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
//
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
//
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
//	4.5 Getters and Setters for ID, created_at and updated_at
	
	public Long getId() {
		return id;
	}
	public void setID(Long id) {
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
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void getUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
//	5. Created and Updated At annotations
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
	

}
