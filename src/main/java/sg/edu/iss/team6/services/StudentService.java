package sg.edu.iss.team6.services;

import java.util.ArrayList;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.StudentAttendCourse;
import sg.edu.iss.team6.model.Students;

public interface StudentService {

	
	/*ArrayList<Students> findStudent(String lecturerId);
	
	Students findStudentById(String s);
	
	ArrayList<Students> findAllStudents();
	
	Students findStudnet(String studid);
	
	ArrayList<String> findAllCoursesofStudents();
	
	ArrayList<String> findAllStudentIDs();*/
	
    
	
	ArrayList<Courses> findAvailableCoursesByStudentId(String studentId);

	int getCourseCapacityById(String courseId);
	
	int getActualEnrolledById(String courseId);
	
	Courses findCourseByCourseId(String courseId);
	
	
	
}