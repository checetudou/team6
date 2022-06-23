package sg.edu.iss.team6.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.iss.team6.helper.UserSession;
import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.StudentAttendCourse;
import sg.edu.iss.team6.services.CourseService;
import sg.edu.iss.team6.services.StudentAttendCourseService;
import sg.edu.iss.team6.services.StudentService;
import sg.edu.iss.team6.helper.CourseEventEnum;
import sg.edu.iss.team6.model.CourseEvent;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private StudentService sService;
	
	@Autowired
	private CourseService cService;
	
	@Autowired
	private StudentAttendCourseService sacService;


	@RequestMapping(value = "/grades")
	public String studentGrades(HttpSession session, Model model) {
		UserSession usession = (UserSession) session.getAttribute("usession");
		
    if (usession.getStudent() != null) {
			
			if (sacService.findStudentAttendCourseByStudentId(usession.getStudent().getStudentId()).size() > 0) {
				model.addAttribute("cStudentAttendCourses", sacService.findStudentAttendCourseByStudentId(usession.getStudent().getStudentId()));
				
			}
			
		ArrayList<StudentAttendCourse> courses = sacService.findStudentAttendCourseByStudentId(usession.getStudent().getStudentId());
		double totalMarks = 0;
		double gpa = 0;
		Map<String, Double> gradeMap = new HashMap<String, Double>()
		{
			{
				put("A",5.0);
				put("B",4.0);
				put("C",3.0);
				put("D",2.5);
				put("Pass",2.0);
				put("Fail",0.0);
			}
		};
		
		for (StudentAttendCourse course : courses)
		{
			totalMarks += gradeMap.get(course.getGrade());
		}
		
		gpa = totalMarks / 4 * courses.size();
		model.addAttribute("gpa",gpa);
		
			return "student-grades";
		}
		return "common-login";
	}
	
	@RequestMapping(value = "/courses")
	public String studentCourses(HttpSession session, Model model) {
		UserSession usession = (UserSession) session.getAttribute("usession");
		if (usession.getStudent() != null) {
			
			if (sService.findAvailableCoursesByStudentId(usession.getStudent().getStudentId()).size() > 0) {
				model.addAttribute("cCourses", sService.findAvailableCoursesByStudentId(usession.getStudent().getStudentId()));
				
			}
			return "student-available-courses";
		}
		return "forward:/home/login";
	}

	
	@RequestMapping(value = "/enroll/{id}", method = RequestMethod.GET)
	public String enrollCourse(@PathVariable String id, HttpSession session, Model model) {
		
		UserSession usession = (UserSession) session.getAttribute("usession");
		Courses course = sService.findCourseByCourseId(id);
		
		if (course.getActualEnroll() < course.getSize()) {
			course.setActualEnroll(course.getActualEnroll() + 1);
			StudentAttendCourse SAC = new StudentAttendCourse();
			SAC.setStudents(usession.getStudent());
			SAC.setCourses(course);
			sacService.createStudentAttendCourse(SAC);
			cService.updateCourse(course);
			//model.addAttribute("status","success");
		}
		
		//else {
			//model.addAttribute("status","unsucessful")
		//}
		return "enrollment-result";
	}
			

}
