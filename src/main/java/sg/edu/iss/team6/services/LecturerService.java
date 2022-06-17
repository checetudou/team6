package sg.edu.iss.team6.services;

import java.util.ArrayList;

import sg.edu.iss.team6.model.Lecturers;

public interface LecturerService {
	
	ArrayList<Lecturers> findCoursesByLecturer(String s);
	
	ArrayList<Lecturers> coursesByLecturer();
	
	Lecturers findLecturerById(String s);
	
	ArrayList<Lecturers> findAllLecturers();
	
	Lecturers findLecturer(String lecturerId);
	
	Lecturers createLecturer(Lecturers lecturer);
	
	Lecturers removeLecturer(Lecturers lecturer);
	
	
	

}
