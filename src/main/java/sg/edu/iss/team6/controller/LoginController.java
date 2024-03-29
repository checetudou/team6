package sg.edu.iss.team6.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

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

	@GetMapping(value = "/")
	public String student(Model model) {
		model.addAttribute("user", new User());
		return "common-login";
	}

	@GetMapping(value = "/home")
	public String home() {
		return "common-home";
	}

	@GetMapping(value = "/about")
	public String about() {
		return "about";
	}

    @GetMapping(value = "/contact")
	public String contact() {
		return "contact";
	}

	@GetMapping(value = "/authenticate")
	public String authenticate(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model, HttpSession session) {
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
		return "forward:/home";
	}

}
