package sg.edu.iss.team6.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.team6.helper.UserSession;
import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.StudentAttendCourse;
import sg.edu.iss.team6.repo.CourseRepo;
import sg.edu.iss.team6.repo.StudentAttendCourseRepo;
import sg.edu.iss.team6.services.AdminCourse;
import sg.edu.iss.team6.services.AdminStudent;


public class Admin_Enrolment {

	@Autowired
	private AdminStudent adeserv;
	
	@Autowired
	private StudentAttendCourseRepo SC;
	
	@Autowired
	private CourseRepo cr;
	
	@Autowired
	private AdminCourse adcserv;

// clicking into manage enrollment should return a list of courses
// it should be the same page as when you click into manage courses	

	@RequestMapping("/managecourse")
	public String allCoursesPage (Model model){
		model.addAttribute("listCourse", adcserv.getAllCourses());
		return "courseindex";
	}
	
	private Object getAllCourses() {
		// TODO Auto-generated method stub
		return null;
	} 

	@GetMapping("/{courseId}/addStudent")
	public String newStudentinCourse (@PathVariable(value="courseId") String courseId, Model model){
		StudentAttendCourse student = new StudentAttendCourse();
		model.addAttribute("studentattendcourse", student);
		return "updatecourse";
	}

	@PostMapping("/saveCourse/{courseId}")
	public String saveCourse (HttpSession session, Model model, @ModelAttribute("courseId") String id){
		//TODO Proper implementation
		// session = session.getAttribute(usession);
		// ArrayList<Courses> c = cr.findCoursesByCourseId(id);
		// SC.saveAllAndFlush(course);	
		return "redirect:/";
	}
	
	// @GetMapping("/{courseId}/deleteStudent")
	// public String deleteStudent(@PathVariable(value="courseId") String courseId, @RequestMapping("id") String id, Model model){
	// 	adeserv.deleteStudentInCourseById(id); //input from frontend to backend
	// 	return "updatecourse";
	// }

	private void deleteStudent(String courseId) {
		// TODO Auto-generated method stub		
	}

}
