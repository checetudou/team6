package sg.edu.iss.team6.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.StudentAttendCourse;
import sg.edu.iss.team6.repo.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Resource
	private CourseRepo courseRepo;
	
	@Override
	@Transactional
	public ArrayList<Courses> findAllCourses() {
		ArrayList<Courses> l = (ArrayList<Courses>) courseRepo.findAll();
		return l;
	}

	@Override
	@Transactional
	public Courses findCourse(String courseId) {
		return courseRepo.findById(courseId).orElse(null);

	}

	@Override
	@Transactional
	public Courses createCourse(Courses course) {
		return courseRepo.saveAndFlush(course);
	}

	@Override
	@Transactional
	public Courses changeCourse(Courses course) {
		return courseRepo.saveAndFlush(course);
	}

	@Override
	@Transactional
	public void removeCourse(Courses course) {
		courseRepo.delete(course);
	}

	@Override
	@Transactional
	public ArrayList<Courses> findCoursesByLecturerId(String lecturerId) {
		return courseRepo.findCoursesByLecturerId(lecturerId);
	}
	
	@Override
	@Transactional
	public ArrayList<StudentAttendCourse> findCoursesByStudentId(String studentId) {
		return courseRepo.findCoursesByStudentId(studentId);
	}
}
