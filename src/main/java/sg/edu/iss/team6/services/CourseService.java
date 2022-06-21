package sg.edu.iss.team6.service;

import java.util.ArrayList;

import sg.edu.iss.team6.model.*;

public interface CourseService {

	ArrayList<Courses> findAllCourses();

	Courses findCourse(String ceid);

	Courses createCourse(Courses course);

	Courses changeCourse(Courses course);

	void removeCourse(Courses course);

	ArrayList<Courses> findCoursesByLecturerId(String lecturerId);

	
	ArrayList<StudentAttendCourse> findCoursesByStudentId(String studentId);

}