package sg.edu.iss.team6.service;

import java.util.ArrayList;

import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.model.Students;


public interface UserService {

	ArrayList<Students> findStudentBystuID(String studentId);

	ArrayList<Lecturers> findLecturerBylecID(String lecturerId);
	
	Students authenticateStudents(String stuid, String pwd);
	
	Lecturers authenLecturers(String lecid, String pwd);


	

}
