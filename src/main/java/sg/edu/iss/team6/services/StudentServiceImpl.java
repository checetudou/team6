package sg.edu.iss.team6.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.Students;
import sg.edu.iss.team6.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{

	@Resource
	private StudentRepo srepo;

	@Override
	public ArrayList<Students> findAllStudents() {
		return (ArrayList<Students>) srepo.findAll();
	}

	@Override
	public ArrayList<Students> findStudentsById(String studentId) {
		return srepo.findStudentsByStudentId(studentId);
	}

	@Override
	public Students findStudentById(String studentId) {
		return srepo.findStudentByStudentId(studentId);
	}

	@Override
	public ArrayList<Courses> findAvailableCoursesByStudentId(String studentId) {
		return srepo.findAvailableCoursesByStudentId(studentId);
	}
	


}