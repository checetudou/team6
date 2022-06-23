package sg.edu.iss.team6.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.repo.CourseRepo;

@Service
public class AdminCourseImpl implements AdminCourse {
	
	@Resource
	private CourseRepo crepo;

	@Override
	public ArrayList<Courses> getAllCourses() {
		return (ArrayList<Courses>) crepo.findAll();
	}

	@Override
	public Courses getCourseById(String courseId) {
		return crepo.findCourseByCourseId(courseId);
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
	public void deleteCourse(Courses courses) {
		crepo.delete(courses);
	}
	
}

