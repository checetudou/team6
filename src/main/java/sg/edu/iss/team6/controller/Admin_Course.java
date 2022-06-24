package sg.edu.iss.team6.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.model.StudentAttendCourse;
import sg.edu.iss.team6.model.Students;
import sg.edu.iss.team6.services.AdminCourse;
import sg.edu.iss.team6.services.AdminStudent;
import sg.edu.iss.team6.services.LecturerService;
import sg.edu.iss.team6.services.StudentAttendCourseService;

@Controller
@RequestMapping(value = "/admin/courses/")
public class Admin_Course {
	
	@Autowired
	private AdminCourse adcserv;

	@Autowired
	private AdminStudent adsserv;

	@Autowired
	private StudentAttendCourseService sacserv;

	@Autowired
	private LecturerService lServ;

	@InitBinder("admin")
	private void initUserBinder(WebDataBinder binder) {
		// TODO Validator for admin (if required)
	}
	
	@GetMapping("/allCourses")
	public String allCoursesPage (Model model){
		ArrayList<Courses> courseList = adcserv.getAllCourses();
		model.addAttribute("courseList", courseList);
		return "admin-courses_courselist";
	}

	@GetMapping("/createCourse")
	public String newCoursePage(Model model) {
		Courses course = new Courses();
		model.addAttribute("course", course);
		return "newCourse"; // TODO use the correct html page
	}	

	@PostMapping("/saveCourse")
	public String saveCourse (@ModelAttribute("course") @Valid Courses course, BindingResult result){
		if (result.hasErrors()) {
			return "newCourse"; // TODO use the correct html page
		}
		adcserv.addCourse(course);
		return "forward:/managecourses"; // TODO use the correct html page
	}

	@GetMapping("/updateCourse/{courseId}")
	public String updateCourse (@PathVariable(value="courseId") String courseId, Model model){
		Courses course = adcserv.getCourseById(courseId);
		ArrayList<Lecturers> lecturers = lServ.findAllLecturers();
		model.addAttribute("course", course);
		model.addAttribute("lecturerList", lecturers);
		return "admin-course_editcourseenrollment"; 
	}

	@PostMapping("/updateCourse/{courseId}")
	public String updatedCourse (@PathVariable(value="courseId") String courseId, @ModelAttribute @Valid Courses course, BindingResult result, Model model){
		if (result.hasErrors()) {
			return "admin-course_editcourseenrollment"; 
		}
		adcserv.updateCourse(course);
		return "redirect:/admin/courses/allCourses";
	}

	@PostMapping ("/searchCourse")
	public String searchedCourse(@Param("courseId") String courseId, Model model){
		List<Courses> listCourse = adcserv.getCoursesById(courseId);
		model.addAttribute("listCourse", listCourse);
		return "courseindex"; // TODO use the correct html page
	}

	@GetMapping("/deleteCourse/{courseId}")
	public String deleteCourse(@PathVariable(value="courseId") String courseId, Model model){
		// TODO delete all lecturecanteach rows associated with this course before can call delete.
		adcserv.deleteCourse(adcserv.getCourseById(courseId));
		return "redirect:/admin/courses/allCourses";
	}

	@GetMapping("/addStudentToCourse/{id}")
	public String newStudentinCourse (@PathVariable(value="courseId") String courseId, Model model){
		Courses c = adcserv.getCourseById(courseId);
		ArrayList<Students> studentList = adsserv.getAllStudentProfile();
		Students stu = new Students();
		model.addAttribute("studentlist", studentList);
		model.addAttribute("student", stu);
		model.addAttribute("Course", c);
		return "addstudenttocourse"; // TODO use the correct html page
	}
	
	//TODO if have time: searching for student to add to course
	// @PostMapping("/addStudentToCourse/{id}")
	// public String searchingStudentinCourse (@Param(value="searchStudent") String searchString, @PathVariable(value="courseId") String courseId, Model model){
	// 	ArrayList<Students> studentList = adsserv.returnStudentsProfileById(searchString);
	// 	model.addAttribute("studentlist", studentList);
	// 	return "addstudenttocourse"; // TODO use the correct html page
	// }

	@PostMapping("/adding")
	public String newStudentaddedinCourse (@ModelAttribute Students student, @ModelAttribute Courses c, Model model){
		// TODO proper custom validator
		if (c.getActualEnroll() >= c.getSize()) {
			return "courseindex"; // TODO use the correct html page
		}
		else {
			StudentAttendCourse ballsac = new StudentAttendCourse(student, c, null);
			sacserv.createStudentAttendCourse(ballsac);
			student.getStudentAttendCourses().add(ballsac);
			c.getStudentAttendCourses().add(ballsac);
			c.setActualEnroll(c.getActualEnroll()+1);
		}
		return "courseindex"; //TODO proper html page
	}

	@GetMapping("delete/{courseid}/{studentid}")
	private String deleteStudent(@PathVariable(value="courseid") String courseid, @PathVariable(value="studentid") String studentid, Model model) {
		Courses c = adcserv.getCourseById(courseid);
		Students s = adsserv.getStudentProfileById(studentid);

		StudentAttendCourse sac = sacserv.findStudentAttendCourseByCourseIdAndStudentId(studentid, courseid);
		s.getStudentAttendCourses().remove(sac);
		c.getStudentAttendCourses().remove(sac);
		c.setActualEnroll(c.getActualEnroll()-1);
		return "courseindex"; //TODO set proper html page
	}


	// TODO Pagination
	// protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 	response.setContentType("text/html");
	// 	PrintWriter printWriterOut=response.getWriter();
	// 	String stringPageNumber=request.getParameter("page");
	// 	int paginationPageID=Integer.parseInt(stringPageNumber);
	// 	int toalCount=pageNumbers;
	// 	if(paginationPageID==1){

	// 	}
	// 	else{
	// 		paginationPageID=paginationPageID-1;
	// 		paginationPageID=paginationPageID*toalCount+1;
	// 	}
	// }

}
