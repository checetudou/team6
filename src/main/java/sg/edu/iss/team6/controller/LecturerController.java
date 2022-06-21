package sg.edu.iss.team6.controller;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import sg.edu.iss.team6.helper.Grade;
import sg.edu.iss.team6.model.CourseEvent;
import sg.edu.iss.team6.helper.CourseEventEnum;
import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.LectureCanTeach;
import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.model.StudentAttendCourse;
import sg.edu.iss.team6.services.CourseService;
import sg.edu.iss.team6.services.StudentService;
import sg.edu.iss.team6.controller.UserSession;

import sg.edu.iss.team6.repo.CourseRepo;

@Controller
@RequestMapping(value = "/lecturers")
public class LecturerController {

	@Autowired
	private CourseService cService;
	
	@Autowired
	private StudentService sService;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		
	}
	
	@RequestMapping(value = "/courses")
	public String lecturerViewCurrentCourses(HttpSession session, Model model) {
		UserSession usession = (UserSession) session.getAttribute("usession");
		if (usession.getLecturer() != null) {
			System.out.println(usession.getLecturer());
			if (cService.findCoursesByLecturerId(usession.getLecturer().getLecturerId()).size() > 0) {
				model.addAttribute("chistory", cService.findCoursesByLecturerId(usession.getLecturer().getLecturerId()));
			}
			return "lecturer-viewcurrentcourses";
		}
		return "forward:/home/login";
	}
	
	@RequestMapping(value = "/student/grade/{id}", method = RequestMethod.POST)
	public ModelAndView gradeStudent(@ModelAttribute("grade") @Valid Grade grade,BindingResult result, @PathVariable Integer id, HttpSession session) {
		UserSession usession = (UserSession) session.getAttribute("usession");
		if (result.hasErrors())
			return new ModelAndView("lecturer-coursestudentlist");
		String studentid = id.toString();
		StudentAttendCourse sac = sService.findStudentByStudentId(studentid);
		CourseEvent ce = new CourseEvent();
		
		if (CourseEventEnum.A.toString() != null) {
			ce.setEventType(CourseEventEnum.A);
			sac.setGrade(CourseEventEnum.A);
		} 
		
		else if (CourseEventEnum.B.toString() != null) {
			ce.setEventType(CourseEventEnum.B);
			sac.setGrade(CourseEventEnum.B);
		} 
		else if (CourseEventEnum.C.toString() != null) {
			ce.setEventType(CourseEventEnum.C);
			sac.setGrade(CourseEventEnum.C);
		} 
		else if (CourseEventEnum.D.toString() != null) {
			ce.setEventType(CourseEventEnum.D);
			sac.setGrade(CourseEventEnum.D);
		} 
		else if (CourseEventEnum.P.toString() != null) {
			ce.setEventType(CourseEventEnum.P);
			sac.setGrade(CourseEventEnum.P);
		} 			
		else {
			ce.setEventType(CourseEventEnum.F);
			sac.setGrade(CourseEventEnum.F);
		}

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
