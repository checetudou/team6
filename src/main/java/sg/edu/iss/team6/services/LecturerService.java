package sg.edu.iss.team6.services;

import java.util.ArrayList;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.Lecturers;

public interface LecturerService {
	
	
	ArrayList<Courses> coursesByLecturer(String lecturerId);
	
	ArrayList<Lecturers> findAllLecturers();
	
	Lecturers findLecturer(String lecturerId);
	
	Lecturers createLecturer(Lecturers lecturer);
	
	Lecturers removeLecturer(Lecturers lecturer);

	Lecturers updateLecturer(Lecturers lecturer);
	
	
	

}
