package sg.edu.iss.team6.services;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

import sg.edu.iss.team6.model.Lecturers;

@Service
public interface AdminLecturer {
	
	//Lecturer profile
	List<Lecturers> getAllLecturer(Pageable pageable);
	Lecturers getLecturer (String name);
	// Lecturers addLecturer (String name); -> in controller
	void saveLecturer (Lecturers lecturer);
	void deleteLecturerById (String lecturerId);
	List<Lecturers> returnLecturerById (String name);
	// update Lecturer -> in controller

}
