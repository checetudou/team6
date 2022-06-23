package sg.edu.iss.team6.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import org.thymeleaf.util.StringUtils;
import sg.edu.iss.team6.helper.UserSession;
import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.model.Students;
import sg.edu.iss.team6.model.User;
import sg.edu.iss.team6.services.UserService;
import sg.edu.iss.team6.validators.UserValidator;

@Controller
public class LoginController {

	@Autowired
	private UserService uservice;

	@Autowired
	private UserValidator uVal;

	@InitBinder("user")
	private void initDepartmentBinder(WebDataBinder binder) {
		binder.addValidators(uVal);
	}

	@RequestMapping(value = "/")
	public String student(Model model) {
		model.addAttribute("user", new User());
		return "common-login";
	}

	@RequestMapping(value = "/about")
	public String home() {
		return "about";
	}

	@RequestMapping(value = "/contact")
	public String contact() {
		return "contact";
	}

	@RequestMapping(value = "/home/authenticate")
	public String authenticate(@ModelAttribute("user") User user, BindingResult bindingResult, Model model, HttpSession session) {
		if (bindingResult.hasErrors()) {
			return "common-login";
		} else {
			UserSession usession = new UserSession();
			if ((user.getUserId().substring(0, 7).equals("nusstu/"))) {
				Students s = uservice.findStudentBystuID(user.getUserId().substring(7));
				usession.setStudent(s);
			}
			if ((user.getUserId().substring(0, 7).equals("nusstf/"))) {
				Lecturers l = uservice.findLecturerBylecID(user.getUserId().substring(7));
				usession.setLecturer(l);
				usession.setAdminOrNot(l.isAdminOrNot());
			}
			session.setAttribute("user", usession);
		}
		return "common-home";
	}

}
