package sg.edu.iss.team6.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.iss.team6.model.Courses;

@Service
public interface AdminCourse {
	
	List<Courses> getAllCourses();

	Courses getCourseById(String courseId);

	void saveCourse(Courses courses);

	void deleteCourse(String courseId);

	List<Courses> returnCourseById(String courseId);

	void addCourse(Courses courses);

	void updateCourse(Courses courses);

}
