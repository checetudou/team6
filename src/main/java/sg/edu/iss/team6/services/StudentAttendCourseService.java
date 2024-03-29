package sg.edu.iss.team6.services;

import java.util.ArrayList;

import sg.edu.iss.team6.model.StudentAttendCourse;

public interface StudentAttendCourseService {

	ArrayList<StudentAttendCourse> findStudentAttendCourseByStudentId(String StudentId);

	void createStudentAttendCourse(StudentAttendCourse SAC);

	void saveAllAndFlush(ArrayList<StudentAttendCourse> sacList);

	ArrayList<StudentAttendCourse> findStudentAttendCourseByCourseId(String courseId);

	StudentAttendCourse findStudentAttendCourseByCourseIdAndStudentId(String studentId, String courseId);
}
