package sg.edu.iss.team6.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.model.Students;
import sg.edu.iss.team6.service.UserService;

@Controller

public class LoginController {
	@Autowired
	private UserService uservice;
	
	@RequestMapping(value = "/")
	public String student(Model model) {
		model.addAttribute("Student", new Students());
		return "login";
	}

	@RequestMapping(value = "/home")
	public String lecturer(Model model) {
		model.addAttribute("Lecturer", new Lecturers());
		return "login";
	}

	@RequestMapping(value = "/home")
	public String logic(Model model) {
		model.addAttribute("Admin", new Lecturers());
		return "login";
	}
	@RequestMapping(value = "/home/authenticate")
	public String authenticate(@ModelAttribute("student") Students student, BindingResult bindingResult, 
			Model model,HttpSession session) 
	{
		UserSession usession = new UserSession();
		if (bindingResult.hasErrors()) {
			return "login";
		}else
		{
			Students s = uservice.authenticateStudents(student.getStudentId(), student.getPassword());
			usession.setStudent(s);
		
		}
		session.setAttribute("student", usession);
		return "null";
	}
	
	@RequestMapping(value = "/home/authenticate")
	public String authenticate(@ModelAttribute("lecturer")Lecturers lecturer, BindingResult bindingResult,
			Model model, HttpSession session) {
		UserSession usession = new UserSession();
		if(bindingResult.hasErrors()) {
			return "login";
		}else
		{
			Lecturers l = uservice.authenLecturers(lecturer.getLecturerId(), lecturer.getPassword());
			usession.setLecturerId(l);
			
		}
		session.setAttribute("lecturer", usession);
		return "null";
	}
//	@RequestMapping(value = "/home/authenticate")
//	public String authenticate(@ModelAttribute("admin")Lecturers lecturer, BindingResult bindingResult,
//			Model model, HttpSession session) {
//		UserSession usession = new UserSession();
//		if(bindingResult.hasErrors()) {
//			return "login";
//		}else
//		{
//			Lecturers l = uservice.authenLecturers(lecturer.getLecturers(), lecturer.getPassword());
//			usession.setAdminId(l);
//		}
//		session.setAttribute("lecturer", usession);
//		return "null";
//	}
		//if (("nusstu")){
	//			Students studentFromDatabase = uservice.findStudentBystuID(studentId);
//				authen(studentfFromDatabase.stuid, student.password) {
//				if studentFromDatabase.password == student.password {
//						allow login;
//					}
//				}
				
	//		}
//			else contains nusstf && lecturer.adminornot==true
			
			

//			usession.setLecturerId(lservice.findLecturerById(usession.getLecturerId().getPassword()));
//			ArrayList<Lecturers> lecturers = lservice.findAllLecturers(usession.getLecturerId().getLectureCanTeaches());
//			if (lecturers !=) {
////				usession.setSubordinates(subordinates);
////			}
////			session.setAttribute("usession", usession);
//			return "null";
////		}

	//}

	@RequestMapping(value = "/about")
	public String home() {
		return "about";
	}

}
