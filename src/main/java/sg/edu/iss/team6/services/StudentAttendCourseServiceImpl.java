package sg.edu.iss.team6.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.edu.iss.team6.model.StudentAttendCourse;
import sg.edu.iss.team6.repo.StudentAttendCourseRepo;



@Service
public class StudentAttendCourseServiceImpl implements StudentAttendCourseService {

	@Resource
	private StudentAttendCourseRepo sacRepo;

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

}

