package sg.edu.iss.team6.services;

import java.util.ArrayList;


import javax.annotation.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team6.model.Lecturers; 
import sg.edu.iss.team6.repo.*;

@Service
public abstract class LecturerServiceImpl implements LecturerService{
	
	@Resource
	private LecturerRepo lecturerRepo;
	
	@Override
	@Transactional
	public ArrayList <Lecturers> findCoursesByLecturers(String s){
		return lecturerRepo.findCoursesByLecturers(s);
	}
	
	@Override
	@Transactional
	public ArrayList <Lecturers> coursesByLecturer(String lecturerId){
		return lecturerRepo.coursesByLecturer(lecturerId);
	}
	
	@Override
	@Transactional
	public ArrayList<Lecturers> findAllLecturers(){
		ArrayList <Lecturers> l = (ArrayList<Lecturers>) lecturerRepo.findAll();
		return l;
	}
	
	@Override
	@Transactional
	public Lecturers findLecturer(String lecturerId) {
		return lecturerRepo.findById(lecturerId).orElse(null);
	}
	
	@Override
	@Transactional
	public Lecturers createLecturer(Lecturers lecturer) {
		return lecturerRepo.saveAndFlush(lecturer);
	}
	/*
	@Override
	@Transactional
	public Lecturers removeLecturer(Lecturers lecturer) {
		return lecturerRepo.delete(lecturer);
	}
	
	*/

}
