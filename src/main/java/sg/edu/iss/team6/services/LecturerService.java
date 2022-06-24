package sg.edu.iss.team6.services;

import java.util.ArrayList;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.Lecturers;

public interface LecturerService {	
	
	ArrayList<Courses> coursesByLecturer(String lecturerId);

	void updateGradesByCourseidAndUserid(String courseid,String studentid,String grade);
	
	ArrayList<Lecturers> findAllLecturers();
	
	Lecturers findLecturer(String lecturerId);
	
	void createLecturer(Lecturers lecturer);
	
	void removeLecturer(Lecturers lecturer);

	void updateLecturer(Lecturers lecturer);
	
	
	

}
