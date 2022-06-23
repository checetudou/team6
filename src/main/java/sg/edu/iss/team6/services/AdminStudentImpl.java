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
public class AdminStudentImpl implements AdminStudent{

	@Resource
	private StudentAttendCourseRepo sacRepo;

	@Resource
	private StudentRepo srepo;

	@Resource
	private LecturerRepo lrepo;

	@Resource
	private CourseRepo crepo;

	@Override
	public ArrayList<Students> getAllStudentProfile() {
		return (ArrayList<Students>) srepo.findAll();
	}

	@Override
	public ArrayList<Students> returnStudentsProfileById(String id) {
		return srepo.findStudentsByStudentId(id);
	}

	@Override
	public Students getStudentProfileById(String id) {
		return srepo.findStudentByStudentId(id);
	}

	@Override
	public void updateStudent(Students student) {
		srepo.saveAndFlush(student);
	}

	@Override
	public void addStudent(Students student) {
		srepo.saveAndFlush(student);
	}

	@Override
	public void deleteStudentProfileById(String id) {
		Students s = srepo.findStudentByStudentId(id);
		srepo.delete(s);	
	}

	@Override
	public ArrayList<Students> getAllStudentsInCourse(String courseId) {
		ArrayList<Students> sInCourse = new ArrayList<>();
		ArrayList<StudentAttendCourse> sacList = (ArrayList<StudentAttendCourse>)sacRepo.getStudentAttendCourseListByCourseId(courseId);
		for (StudentAttendCourse ballsac : sacList) {
			sInCourse.add(ballsac.getStudents());
		}
		return sInCourse;
	}

	@Override
	public void addStudentToCourse(String courseId, String studentId) {
		Courses c = crepo.findCourseByCourseId(courseId);
		Students s = srepo.findStudentByStudentId(studentId);
		StudentAttendCourse sac_new = new StudentAttendCourse(s, c, null);
		s.getStudentAttendCourses().add(sac_new);
	}

	@Override
	public void deleteStudentInCourseById(String courseId, String studentId) {
		StudentAttendCourse sac_found = sacRepo.getStudentAttendCourseByStudentIdAndCourseId(courseId, studentId);
		Students s = srepo.findStudentByStudentId(studentId);
		s.getStudentAttendCourses().remove(sac_found);
	}
}

