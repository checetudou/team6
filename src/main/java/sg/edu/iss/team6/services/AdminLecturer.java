package sg.edu.iss.team6.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import sg.edu.iss.team6.model.Lecturers;

public interface AdminLecturer {
	
	ArrayList<Lecturers> getAllLecturers(Pageable pageable);

	Lecturers getLecturer(String id);

	List<Lecturers> getLecturersById (String lecturerid);

	void addLecturer(Lecturers lecturer);

	void saveLecturer (Lecturers lecturer);

	void deleteLecturerById (String lecturerId);

}
