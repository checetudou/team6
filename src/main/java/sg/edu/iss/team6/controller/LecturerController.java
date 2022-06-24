package sg.edu.iss.team6.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.model.StudentAttendCourse;
import sg.edu.iss.team6.model.Students;
import sg.edu.iss.team6.services.LecturerService;
import sg.edu.iss.team6.services.StudentAttendCourseService;
import sg.edu.iss.team6.services.StudentService;

@Controller
@RequestMapping(value = "/lecturers")
public class LecturerController {

	@Autowired
	private StudentService sService;

	@Autowired
	private LecturerService lService;

	@Autowired
	private StudentAttendCourseService sacService;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		//TODO if got time
	}

	@RequestMapping(value = "/courselist", method = RequestMethod.GET)
	public String lectureCanTeachList(HttpSession session, Model model) {
		//TODO Use HttpSession to check if the User entering this page is ONLY an authorised person that can see his courses(lecturers/admin)
		Lecturers l = (Lecturers) session.getAttribute("user");
		ModelAndView mav = new ModelAndView("lecture-can-teach"); //TODO insert proper html page name
		ArrayList<Courses> courses = lService.coursesByLecturer(l.getLecturerId());
		mav.addObject("courseslist", courses);
		mav.addObject("lecturer", l);
		return "lecturer-viewcurrentcourses";
	}

	@RequestMapping(value = "/courselist/{courseid}", method = RequestMethod.GET)
	public ModelAndView enrollmentList(@PathVariable String courseId, HttpSession session) {
		//TODO Use HttpSession to check if the User entering this page is ONLY an authorised person that can see his courses(lecturers/admin)
		ModelAndView mav = new ModelAndView("lecture-can-teach"); //TODO insert proper html page name
		ArrayList<StudentAttendCourse> sacList = sacService.findStudentAttendCourseByCourseId(courseId);
		mav.addObject("studentattendcourselist", sacList);

		return mav;
	}

	@RequestMapping(value = "/gradestudent/{id}", method = RequestMethod.GET)
	public ModelAndView gradeStudent(@PathVariable String id, HttpSession session) {
		// TODO Use HttpSession to check if the User entering this page is ONLY an authorised person that can change grades(lecturers/admin)
		ArrayList<StudentAttendCourse> sacList = sacService.findStudentAttendCourseByStudentId(id);
		Students s = sService.findStudentById(id);
		ModelAndView mav = new ModelAndView("gradeStudents"); // TODO insert proper html page name
		mav.addObject("studentattendcourselist", sacList);
		mav.addObject("student", s);
		return mav;
	}

	@RequestMapping(value = "/gradestudent/{id}", method = RequestMethod.POST)
	public ModelAndView gradeStudent(@ModelAttribute("studentattendcourselist") ArrayList<StudentAttendCourse> sacList, @PathVariable Integer id, HttpSession session) {
		// TODO Use HttpSession to check if the User entering this page is ONLY an authorised person that can change grades(lecturers/admin)
		sacService.saveAllAndFlush(sacList);
		ModelAndView mav = new ModelAndView("gradeStudents"); // TODO insert proper html page name
		return mav;
	}


}