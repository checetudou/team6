package sg.edu.iss.team6.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
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
	@ResponseBody
	public List<Courses> listCourses(HttpSession usession) {
		return lService.coursesByLecturer(usession.getId().substring(7));
	}

	@RequestMapping(value = "/grades", method = RequestMethod.POST)
	public String setGrades(@RequestParam("studentid") String studentid, @RequestParam("courseid") String courseid, @RequestParam("grades") String grades) {
		lService.updateGradesByCourseidAndUserid(courseid, studentid, grades);
		return "/EntryScore";
	}


//
//	@RequestMapping(value = "/courselist/{courseid}", method = RequestMethod.GET)
//	public ModelAndView enrollmentList(@PathVariable String courseId, HttpSession session) {
//		//TODO Use HttpSession to check if the User entering this page is ONLY an authorised person that can see his courses(lecturers/admin)
//		ModelAndView mav = new ModelAndView("lecture-can-teach"); //TODO insert proper html page name
//		ArrayList<StudentAttendCourse> sacList = sacService.findStudentAttendCourseByCourseId(courseId);
//		mav.addObject("studentattendcourselist", sacList);
//
//		return mav;
//	}
//
//	@RequestMapping(value = "/gradestudent/{id}", method = RequestMethod.GET)
//	public ModelAndView gradeStudent(@PathVariable String id, HttpSession session) {
//		// TODO Use HttpSession to check if the User entering this page is ONLY an authorised person that can change grades(lecturers/admin)
//		ArrayList<StudentAttendCourse> sacList = sacService.findStudentAttendCourseByStudentId(id);
//		Students s = sService.findStudentById(id);
//		ModelAndView mav = new ModelAndView("gradeStudents"); // TODO insert proper html page name
//		mav.addObject("studentattendcourselist", sacList);
//		mav.addObject("student", s);
//		return mav;
//	}
//
//	@RequestMapping(value = "/gradestudent/{id}", method = RequestMethod.POST)
//	public ModelAndView gradeStudent(@ModelAttribute("studentattendcourselist") ArrayList<StudentAttendCourse> sacList, @PathVariable Integer id, HttpSession session) {
//		// TODO Use HttpSession to check if the User entering this page is ONLY an authorised person that can change grades(lecturers/admin)
//		sacService.saveAllAndFlush(sacList);
//		ModelAndView mav = new ModelAndView("gradeStudents"); // TODO insert proper html page name
//		return mav;
//	}


}