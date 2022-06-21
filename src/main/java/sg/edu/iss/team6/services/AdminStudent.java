package sg.edu.iss.team6.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.iss.team6.model.StudentAttendCourse;
import sg.edu.iss.team6.model.Students;

@Service
public interface AdminStudent {
	
	//student profile
	List<Students> getAllStudentProfile();
	Students getStudentProfileById (String id);
	void deleteStudentProfileById (String id);
	void saveStudentProfile (Students student);

	//student attend course
	List<StudentAttendCourse>  getAllStudentInCourse();
	StudentAttendCourse getStudentById (String id);
	void deleteStudentInCourseById (String id);
	void saveStudentInCourse (StudentAttendCourse student);

}
