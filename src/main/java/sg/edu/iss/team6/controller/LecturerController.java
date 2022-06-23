package sg.edu.iss.team6.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.iss.team6.helper.Grade;
import sg.edu.iss.team6.model.CourseEvent;
import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.Students;
import sg.edu.iss.team6.services.CourseService;
import sg.edu.iss.team6.services.LecturerService;
import sg.edu.iss.team6.services.StudentService;

@Controller
@RequestMapping(value = "/lecturers")
public class LecturerController {

	@Autowired
	private CourseService cService;
	
	@Autowired
	private StudentService sService;

	@Autowired
	private LecturerService 

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		//TODO
	}
	

	/*viewing all courses the lecturer teaches*/
	@RequestMapping(value = "/lectureCanTeach/list/{id}", method = RequestMethod.GET)
	public ModelAndView lectureCanTeachList(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("lecture-can-teach");//"LectureCanTeach-list naming to be confirmed
		ArrayList<Courses> courses= cService.findCoursesByLecturerId(id);
		mav.addObject("courses", courses);
		return mav;
	}

	// TODO make a GET page to retrieve initial grades and courses for the student
	// @RequestMapping(value = "/student/grade/{id}", method = RequestMethod.GET)
	// public ModelAndView gradeStudent(@PathVariable String id, HttpSession session) {
	// 	//TODO Use HttpSession to check if the User entering this page is ONLY an authorised person that can change grades(lecturers/admin)
	// 	ArrayList<Courses> studentCourses = sService.
	// 	return mav;
	// }
	
	@RequestMapping(value = "/student/grade/{id}", method = RequestMethod.POST)
	public ModelAndView gradeStudent(@ModelAttribute("grade") @Valid Grade grade,BindingResult result, @PathVariable Integer id, HttpSession session) {
		if (result.hasErrors())
			return new ModelAndView("lecturer-coursestudentlist");
		String studentid = id.toString();
		ArrayList<Students> sac = sService.findStudentById(studentid);
		CourseEvent ce = new CourseEvent();
		
		// if (CourseEventEnum.A.toString() != null) {
		// 	ce.setEventType(CourseEventEnum.A);
		// 	sac.setGrade(CourseEventEnum.A);
		// } 
		
		// else if (CourseEventEnum.B.toString() != null) {
		// 	ce.setEventType(CourseEventEnum.B);
		// 	sac.setGrade(CourseEventEnum.B);
		// } 
		// else if (CourseEventEnum.C.toString() != null) {
		// 	ce.setEventType(CourseEventEnum.C);
		// 	sac.setGrade(CourseEventEnum.C);
		// } 
		// else if (CourseEventEnum.D.toString() != null) {
		// 	ce.setEventType(CourseEventEnum.D);
		// 	sac.setGrade(CourseEventEnum.D);
		// } 
		// else if (CourseEventEnum.P.toString() != null) {
		// 	ce.setEventType(CourseEventEnum.P);
		// 	sac.setGrade(CourseEventEnum.P);
		// } 			
		// else {
		// 	ce.setEventType(CourseEventEnum.F);
		// 	sac.setGrade(CourseEventEnum.F);
		// }

		ModelAndView mav = new ModelAndView("forward:lecturer-coursestudentlist");
		String message = "Grade has been successfully updated.";
		System.out.println(message);
		return mav;
	}
	
	/*
	@RequestMapping(value = "/studentAttendCourse/{id}", method = RequestMethod.POST)
	public ModelAndView gradeStudent(@PathVariable int id) {
		Courses course = cService.findCourse(id);
		ModelAndView mav = new ModelAndView("manager-course-detail", "course", course);
		mav.addObject("approve", new Approve());
		return mav;
	}

	
	@RequestMapping(value = "/course/edit/{id}", method = RequestMethod.POST)
	public ModelAndView approveOrRejectCourse(@ModelAttribute("approve") @Valid Approve approve, BindingResult result,
			@PathVariable Integer id, HttpSession session) {
		UserSession usession = (UserSession) session.getAttribute("usession");
		if (result.hasErrors())
			return new ModelAndView("manager-course-detail");
		Course c = cService.findCourse(id);
		CourseEvent ce = new CourseEvent();
		if (approve.getDecision().trim().equalsIgnoreCase(CourseEventEnum.APPROVED.toString())) {
			ce.setEventType(CourseEventEnum.APPROVED);
			c.setStatus(CourseEventEnum.APPROVED);
		} else {
			ce.setEventType(CourseEventEnum.REJECTED);
			c.setStatus(CourseEventEnum.REJECTED);
		}
		ce.setEventBy(usession.getEmployee().getEmployeeId());
		ce.setComment(approve.getComment());
		ce.setTimeStamp(Calendar.getInstance().getTime());
		ce.setCourse(c);
		c.addCourseEvent(ce);
		cService.changeCourse(c);
		ModelAndView mav = new ModelAndView("forward:/manager/pending");
		String message = "Course was successfully updated.";
		System.out.println(message);
		return mav;
	}
	
	@RequestMapping(value = "/students/grade/{id}", method = RequestMethod.POST)
	public ModelAndView gradeStudent(@ModelAttribute @Valid Course course, BindingResult result, @PathVariable Integer id,
			HttpSession session) throws CourseNotFound {
		UserSession usession = (UserSession) session.getAttribute("usession");
		if (result.hasErrors())
			return new ModelAndView("staff-course-edit");
		ModelAndView mav = new ModelAndView();
		System.out.println("DATES****" + course.getFromDate() + course.getToDate());
		String message = "New course " + course.getCourseId() + " was successfully created.";
		System.out.println(message);
		course.setEmployeeId(usession.getEmployee().getEmployeeId());
		StudentAttendCourse.setGrade(CourseEventEnum.UPDATED);
		mav.setViewName("forward:/staff/history");
		CourseEvent ce = new CourseEvent();
		ce.setCourse(course);
		ce.setEventBy(usession.getEmployee().getEmployeeId());
		ce.setEventType(CourseEventEnum.UPDATED);
		ce.setTimeStamp(Calendar.getInstance().getTime());
		course.addCourseEvent(ce);
		cService.changeCourse(course);
		return mav;
	}*/

	
	
}
