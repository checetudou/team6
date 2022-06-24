package sg.edu.iss.team6.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.LectureCanTeach;
import sg.edu.iss.team6.repo.CourseRepo;
import sg.edu.iss.team6.repo.LecturerCanTeachRepo;

@Service
public class AdminCourseImpl implements AdminCourse {
	
	@Resource
	private CourseRepo crepo;

	@Resource
	private LecturerCanTeachRepo lctrepo;

	@Override
	public ArrayList<Courses> getAllCourses() {
		return (ArrayList<Courses>) crepo.findAll();
	}

	@Override
	public Courses getCourseById(String courseId) {
		return crepo.findCourseByCourseId(courseId);
	}

	@Override
	public ArrayList<Courses> getCoursesById(String courseId) {
		return (ArrayList<Courses>) crepo.findCoursesByCourseId(courseId);
	}

	@Override
	public void addCourse(Courses courses) {
		crepo.saveAndFlush(courses);	
	}

	@Override
	public void updateCourse(Courses courses) {
		crepo.saveAndFlush(courses);
	}

	@Override
	public void AsignCourse(LectureCanTeach lectureCanTeach) {
		lctrepo.saveAndFlush(lectureCanTeach);
	}

	@Override
	public void deleteCourse(Courses courses) {
		crepo.delete(courses);
	}
	
}

