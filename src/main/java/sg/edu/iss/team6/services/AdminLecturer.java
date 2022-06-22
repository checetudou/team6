package sg.edu.iss.team6.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.iss.team6.model.Lecturers;

@Service
public interface AdminLecturer {
	
	//Lecturer profile
	List<Lecturers> getAllLecturer();

	Lecturers getLecturer(String name);

	//TODO Lecturers addLecturer (String name); -> in controller
	void saveLecturer(Lecturers lecturer);

	void deleteLecturerById(String lecturerId);

	List<Lecturers> returnLecturerById(String name);

	//TODO update Lecturer -> in controller
	Lecturers getLecturerById(String lecturerId);

}
