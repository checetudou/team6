package sg.edu.iss.team6.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team6.model.StudentAttendCourse;
import sg.edu.iss.team6.repo.StudentAttendCourseRepo;



@Service
public class StudentAttendCourseServiceImpl implements StudentAttendCourseService {
	
	@Resource
	private StudentAttendCourseRepo sacRepo;
	
	@Override
	@Transactional
	public void createStudentAttendCourse(StudentAttendCourse SAC) {
		 sacRepo.saveAndFlush(SAC);
	}

	@Override
	public ArrayList<StudentAttendCourse> findStudentAttendCourseByStudentId(String studentId) {
		return (ArrayList<StudentAttendCourse>) sacRepo.getStudentAttendCourseListByStudentId(studentId);
	}

	@Override
	public void saveAllAndFlush(ArrayList<StudentAttendCourse> sacList) {
		sacRepo.saveAllAndFlush(sacList);
	}

	@Override
	public ArrayList<StudentAttendCourse> findStudentAttendCourseByCourseId(String courseId) {
		return (ArrayList<StudentAttendCourse>) sacRepo.getStudentAttendCourseListByCourseId(courseId);
	}

	@Override
	public StudentAttendCourse findStudentAttendCourseByCourseIdAndStudentId(String studentId, String courseId) {
		return sacRepo.getStudentAttendCourseByStudentIdAndCourseId(courseId, studentId);
	}

}

