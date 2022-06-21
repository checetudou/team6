package sg.edu.iss.team6.services;


import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.model.Students;


public interface UserService {

	Students findStudentBystuID(String studentId);

	Lecturers findLecturerBylecID(String lecturerId);
	
	Students authenticateStudents(String stuid, String pwd);
	
	Lecturers authenticateLecturers(String lecid, String pwd);


	

}
