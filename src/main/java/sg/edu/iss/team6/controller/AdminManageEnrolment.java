package sg.edu.iss.team6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.team6.model.Courses;

public class AdminManageEnrolment {

	@Autowired
	private AdminManageCourses adcserv;
	

	@RequestMapping("/admin")
	public String homePage (Model model){
		return "index";  //index page should contain links to the different functions
	}
	
//	@RequestMapping("/course")
//	public String allCoursesPage (Model model){
//		model.addAttribute("listCourse", adcserv.getAllCourses());
//		return "courseindex";
//	}
	
	private Object getAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/newCourse")
	public String newCourse (Model model){
		Courses course = new Courses();
		model.addAttribute("course", course);
		return "newCourse";
	}

	@PostMapping("/saveCourse")
	public String saveCourse (@ModelAttribute("course") AdminManageCourses course){
		adcserv.saveCourse(course);
		return "redirect:/";
	}

//	@GetMapping("/updateCourse/{id}")
//	public String updateCourse (@PathVariable(value="courseid") String id, Model model){
//		Courses course = adcserv.getCourseById(id);
//		model.addAttribute("course", course);
//		return "updateCourse";
//	}

	private Courses getCourseById(String id) {
		// TODO Auto-generated method stub
		return null;
	}




}
