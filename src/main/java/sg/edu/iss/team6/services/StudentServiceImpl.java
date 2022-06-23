package sg.edu.iss.team6.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.Students;
import sg.edu.iss.team6.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Resource
	private StudentRepo studentRepo;

	@Override
	@Transactional
	public ArrayList<Courses> findAvailableCoursesByStudentId(String studentId) {
		return studentRepo.findAvailableCoursesByStudentId(studentId);
	}

	@Override
	public ArrayList<Students> findStudentById(String s) {
		return studentRepo.findstudentsByStudentId(s);
	}
	
//	@Override
//	@Transactional
//	public int getCourseCapacityById(String courseId) {
//		return StudentRepo.getCourseCapacityById(courseId);
//	}
//
//	@Override
//	@Transactional
//	public int getActualEnrolledById(String courseId) {
//		return StudentRepo.getActualEnrolledById(courseId);
//	}
//
	@Override
	@Transactional
	public Courses findCourseByCourseId(String courseId) {
		return studentRepo.findCourseByCourseId(courseId);
	}

}