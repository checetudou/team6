package sg.edu.iss.team6.services;

import java.util.ArrayList;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.LectureCanTeach;

public interface AdminCourse {
	
	ArrayList<Courses> getAllCourses();

	Courses getCourseById(String courseId);

	ArrayList<Courses> getCoursesById(String courseId);

	void addCourse(Courses courses);

	void updateCourse(Courses courses);

	void deleteCourse(Courses courses);

}
