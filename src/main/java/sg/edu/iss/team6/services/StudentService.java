package sg.edu.iss.team6.services;

import java.util.ArrayList;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.Students;

public interface StudentService {

	ArrayList<Students> findAllStudents();

	ArrayList<Students> findStudentsById(String s);

	Students findStudentById(String s);

	ArrayList<Courses> findAvailableCoursesByStudentId(String studentId);

}