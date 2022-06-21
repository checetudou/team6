package sg.edu.iss.team6.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.services.AdminCourse;

@Controller
public class Admin_Course {
	
	@Autowired
	private AdminCourse adcserv;
	
// upon clicking manage courses, I should see a list of courses
	@RequestMapping("/managecourse")
	public String allCoursesPage (Model model){
		model.addAttribute("listCourse", adcserv.getAllCourses());
		return "courseindex";
	}
	
	private Object getAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping("/saveCourse")
	public String saveCourse (@ModelAttribute("course") ToBeDeletedAdminCourses course){
		adcserv.saveCourse(course);
		return "redirect:/managecourses";
	}

	@GetMapping(value = "/create")
	public String newCoursePage(Model model) {
		Courses course = new Courses();
		model.addAttribute("course", course);
		return "newCourse"; //redirecting html page
	
	}
	
	@GetMapping("/updateCourse/{courseId}")
	public String updateCourse (@PathVariable(value="courseId") String id, Model model){
		Courses course = adcserv.getCourseById(courseId);
		model.addAttribute("course", course);
		return "updateCourse";
	}


	@PostMapping ("/searchCourse")
	public String searchCourseById (@Param("courseId") String courseId, Model model){
		List<Courses> listCourse = adcserv.returnCourseById(courseId);
		model.addAttribute("listCourse", listCourse);
		return "courseindex";
	}


	private List<Courses> returnCourseById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/deleteCourse/{courseId}")
	public String deleteCourse(@PathVariable(value="courseId") String courseId, Model model){
		adcserv.deleteCourse(courseId);
		return "redirect:/managecourses";
	}

	private void deleteCourse(String courseId) {
		// TODO Auto-generated method stub
		
	}


	//for pagination
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		PrintWriter printWriterOut=response.getWriter();
//		String stringPageNumber=request.getParameter("page");
//		int paginationPageID=Integer.parseInt(stringPageNumber);
//		int toalCount=pageNumbers;
//		if(paginationPageID==1){}
//		else{
//		paginationPageID=paginationPageID-1;
//		paginationPageID=paginationPageID*toalCount+1;
//		}
//		}

}
