package sg.edu.iss.team6.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.StudentAttendCourse;
import sg.edu.iss.team6.model.Students;
import sg.edu.iss.team6.repo.CourseRepo;
import sg.edu.iss.team6.repo.LecturerRepo;
import sg.edu.iss.team6.repo.StudentAttendCourseRepo;
import sg.edu.iss.team6.repo.StudentRepo;

@Service
public class CourseServiceImpl implements CourseService {

	@Resource
	private CourseRepo crepo;

	@Resource
	private StudentRepo srepo;

	@Resource
	private LecturerRepo lrepo;

	@Resource
	private StudentAttendCourseRepo sacRepo;

	@Override
	public ArrayList<Courses> findAllCourses() {
		return (ArrayList<Courses>) crepo.findAll();
	}

	@Override
	public Courses findCourse(String ceid) {
		return crepo.findCourseByCourseId(ceid);
	}

	@Override
	public void addCourse(Courses course) {
		crepo.saveAndFlush(course);
	}
    
	@Override
	public void updateCourse(Courses course) {
		crepo.saveAndFlush(course);	
	}

	@Override
	public void removeCourse(Courses course) {
		crepo.delete(course);	
	}
	


	@Override
	public ArrayList<Courses> findCoursesByStudentId(String studentId) {
		ArrayList<Courses> studentCourses = new ArrayList<Courses>();
		Students s = srepo.findStudentByStudentId(studentId);
		for (StudentAttendCourse ballsac : s.getStudentAttendCourses()) {
			studentCourses.add(ballsac.getCourses());
		}
		return studentCourses;
	}

	@Override
	public int getCourseCapacityById(String courseId) {
		return crepo.getAllowedSize(courseId);
	}

	@Override
	public int getActualEnrolledById(String courseId) {
		Courses c = crepo.findCourseByCourseId(courseId);
		return c.getActualEnroll();
	}
	
}
