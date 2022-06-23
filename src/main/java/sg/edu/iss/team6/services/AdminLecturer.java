package sg.edu.iss.team6.services;

import java.util.ArrayList;

import sg.edu.iss.team6.model.Lecturers;

public interface AdminLecturer {
	
	ArrayList<Lecturers> getAllLecturers();

	Lecturers getLecturer(String id);

	ArrayList<Lecturers> getLecturersById (String lecturerid);

	void addLecturer(Lecturers lecturer);

	void saveLecturer (Lecturers lecturer);

	void deleteLecturerById (String lecturerId);

}
