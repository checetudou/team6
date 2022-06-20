package sg.edu.iss.team6.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.iss.team6.model.Lecturers;

@Service
public interface AdminLecturer {
	List<AdminLecturer> getAllLecturer();
	Lecturers getLecturer (String Name);
	Lecturers addLecturer (String Name);
	void saveLecturer (Lecturers lecturer);
	void deleteLecturerByName (String Name);
	void deleteLecturerById (String Id);
	List<Lecturers> returnLecturerByName (String Name);

}
