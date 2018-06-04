package com.embaudrit.javathethird.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.embaudrit.javathethird.models.Lecture;
import com.embaudrit.javathethird.repositories.LectureRepository;

@Service
public class LectureService {
	//Inject Repository
	private LectureRepository lRepo;
	
	public LectureService (LectureRepository lRepo) {
		this.lRepo = lRepo;
	}
	
	
	//Create course
	public void createLecture (Lecture lecture) {
		lRepo.save(lecture);
	}
	
	//Find Courses
	public List<Lecture> findAll(){
		return lRepo.findAll();
	}
	
	//Find one specific course
	public Lecture findById(Long id) {
		return lRepo.findById(id).get();
	}
	
	// Update course (will have the same route as the create one)
	public void updateLecture(Lecture lecture) {
		lRepo.save(lecture);
	}
	
	//Delete course
	public void deleteLecture(Lecture lecture) {
		lRepo.delete(lecture);
	}

}
