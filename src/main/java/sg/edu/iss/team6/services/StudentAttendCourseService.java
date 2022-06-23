package sg.edu.iss.team6.services;

import java.util.ArrayList;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.StudentAttendCourse;

public interface StudentAttendCourseService {
	
	StudentAttendCourse createStudentAttendCourse(StudentAttendCourse SAC);

	ArrayList<StudentAttendCourse> findStudentAttendCourseByStudentId(String StudentId);


}
