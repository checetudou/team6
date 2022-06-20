package sg.edu.iss.team6.controllers;

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

@Controller
public class AdminManageCourses {
	
	@Autowired
	private AdminManageCourses adcserv;
	

	@RequestMapping("/admin")
	public String homePage (Model model){
		return "index";  //index page should contain links to the different functions
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";

	}
	
	@RequestMapping("/course")
	public String allCoursesPage (Model model){
		model.addAttribute("listCourse", adcserv.getAllCourses());
		return "courseindex";
	}
	
	private Object getAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

//	@RequestMapping(value = "/history")
//	public String employeeCourseHistory(HttpSession session, Model model) {
//		UserSession usession = (UserSession) session.getAttribute("usession");
//		//ModelAndView mav = new ModelAndView("login");
//		if (usession.getUser() != null) {
//			//mav = new ModelAndView("staff-course-history");
//			System.out.println(usession.getEmployee());
//			if (cService.findCoursesByEID(usession.getEmployee().getEmployeeId()).size() > 0) {
//				model.addAttribute("chistory", cService.findCoursesByEID(usession.getEmployee().getEmployeeId()));
//			}
//			return "staff-course-history";
//		}
//		return "forward:/home/login";
//
//	}


	@PostMapping("/saveCourse")
	public String saveCourse (@ModelAttribute("course") AdminManageCourses course){
		adcserv.saveCourse(course);
		return "redirect:/";
	}

	@RequestMapping(value = "/course/create", method = RequestMethod.GET)
	public ModelAndView newCoursePage() {
		ModelAndView mav = new ModelAndView("staff-course-new");
		mav.addObject("course", new Courses());
		return mav;
	}

//	@RequestMapping(value = "/course/create", method = RequestMethod.POST)
//	public ModelAndView createNewCourse(@ModelAttribute @Validated Courses course, BindingResult result,
//			HttpSession session) {
//		UserSession usession = (UserSession) session.getAttribute("usession");
//		if (result.hasErrors())
//			return new ModelAndView("staff-course-new");
//		ModelAndView mav = new ModelAndView();
//		String message = "New course " + course.getCourseId() + " was successfully created.";
//		System.out.println(message);
//		course.setEmployeeId(usession.getEmployee().getEmployeeId());
//		course.setStatus(CourseEventEnum.SUBMITTED);
//		mav.setViewName("forward:/staff/history");
//		Courses ce = new Courses();
//		ce.setCourseId(course);
//		ce.setEventBy(usession.getEmployee().getEmployeeId());
//		ce.setEventType(CourseEventEnum.SUBMITTED);
//		ce.setTimeStamp(Calendar.getInstance().getTime());
//		adcserv.createCourse(course);
//		return mav;
//	}

	
	
	private void createCourse(Courses course) {
		// TODO Auto-generated method stub
		
	}

	@Transactional  //not sure what transactional does
	@GetMapping("/updateCourse/{id}")
	public String updateCourse (@PathVariable(value="courseid") String id, Model model){
		Courses course = adcserv.getCourseById(id);
		model.addAttribute("course", course);
		return "updateCourse";
	}

	private Courses getCourseById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping ("/searchCourse")
	public String searchCourseById (@Param("id") String id, Model model){
		List<Courses> listCourse = adcserv.returnCourseById(id);
		model.addAttribute("listCourse", listCourse);
		return "courseindex";
	}


	private List<Courses> returnCourseById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping ("/searchCourse")
	public String searchCourseByName (@Param("name") String name, Model model){
		List<Courses> listCourse = adcserv.returnCourseByName(name);
		model.addAttribute("listCourse", listCourse);
		return "courseindex";
	}

	private List<Courses> returnCourseByName(String name) {
		// TODO Auto-generated method stub
		return null;
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
