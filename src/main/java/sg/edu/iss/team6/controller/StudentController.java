package sg.edu.iss.team6.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.services.CourseService;
import sg.edu.iss.team6.services.StudentService;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private StudentService sService;
	
	@Autowired
	private CourseService cService;
	
	@RequestMapping(value = "/grades")
	public String studentGrades(HttpSession session, Model model) {
		UserSession usession = (UserSession) session.getAttribute("usession");
		//ModelAndView mav = new ModelAndView("login");
		if (usession.getStudent() != null) {
			
			//mav = new ModelAndView("student-grades");
			if (cService.findCoursesByStudentId(usession.getStudent().getStudentId()).size() > 0) {
				model.addAttribute("cGrades", cService.findCoursesByStudentId(usession.getStudent().getStudentId()));
			}
			return "student-grades";
		}
		return "forward:/home/login";
	}

	@RequestMapping(value = "/courses")
	public String studentCourses(HttpSession session, Model model) {
		UserSession usession = (UserSession) session.getAttribute("usession");
		//ModelAndView mav = new ModelAndView("login");
		if (usession.getStudent() != null) {

			//mav = new ModelAndView("staff-course-history");
			if (cService.findCoursesByStudentId(usession.getStudent().getStudentId()).size() > 0) {
				model.addAttribute("cCourses", sService.findAvailableCoursesByStudentId(usession.getStudent().getStudentId()));
			}
			return "student-available-courses";
		}
		return "common-login";
	}

	
	@RequestMapping(value = "/enroll/{id}", method = RequestMethod.GET)
	public String enrollCourse(@PathVariable String id, HttpSession session) {
		
		UserSession usession = (UserSession) session.getAttribute("usession");
		Courses course = cService.findCourse(id);
		if (course.getActualEnroll() < course.getSize()){
			course.setActualEnroll(course.getActualEnroll() + 1);
		}
		
		cService.changeCourse(course);
		return "enrollment-result";
	}
			

}
