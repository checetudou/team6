package sg.edu.iss.team6.services;

import java.util.ArrayList;

import sg.edu.iss.team6.model.*;

public interface CourseService {

	ArrayList<Courses> findAllCourses();

	Courses findCourse(String ceid);

	void addCourse(Courses course);

	void updateCourse(Courses course);

	void removeCourse(Courses course);
	
	ArrayList<Courses> findCoursesByStudentId(String studentId);

	int getCourseCapacityById(String courseId);

	int getActualEnrolledById(String courseId);

}