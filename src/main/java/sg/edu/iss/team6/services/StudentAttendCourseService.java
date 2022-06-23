package sg.edu.iss.team6.services;

import java.util.ArrayList;

import sg.edu.iss.team6.model.StudentAttendCourse;

public interface StudentAttendCourseService {

	ArrayList<StudentAttendCourse> findStudentAttendCourseByStudentId(String StudentId);
	
	StudentAttendCourse createStudentAttendCourse(StudentAttendCourse SAC);
}
