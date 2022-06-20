package sg.edu.iss.team6.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.iss.team6.model.Courses;

@Service
public interface AdminCourse {
	
		List<Courses> getAllCourses();
		void saveCourses (Courses courses);
		Courses getCoursesById (String Id);
		Courses getCoursesByName (String name);
		Courses getStudentByName (String name);
		Courses getCurrentSize (int count);
		Courses getAllowedSize (int count);
		void saveAllowedSize (int count);
		Courses getGrade (String grade);
		Courses editGrade (String grade);
		// void saveGrade (Student student/Course course/StudentAttendCourse?)
		List<Courses> returnCourseById(String Id);
		List<Courses> returnCourseByName(String name);

}
