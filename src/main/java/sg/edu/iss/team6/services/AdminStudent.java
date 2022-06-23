package sg.edu.iss.team6.services;

import java.util.ArrayList;

import sg.edu.iss.team6.model.Students;

public interface AdminStudent {

	ArrayList<Students> getAllStudentProfile();
  
	ArrayList<Students> returnStudentsProfileById(String id);
  
	Students getStudentProfileById(String id);

	void updateStudent(Students student);

	void addStudent(Students student);

	void deleteStudentProfileById(String id);

	ArrayList<Students> getAllStudentsInCourse(String courseId);

	void addStudentToCourse(String courseId, String studentId);

	void deleteStudentInCourseById(String courseId, String studentId);

}
