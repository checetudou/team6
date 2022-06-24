package sg.edu.iss.team6.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.iss.team6.model.Students;
import sg.edu.iss.team6.services.AdminStudent;

@Controller
@RequestMapping("/admin/students")
public class Admin_Student {

	@Autowired
	private AdminStudent adsserv;
	
	@GetMapping("/managestudents")
	public String getAllStudentProfile (Model model){
		model.addAttribute("listStudent", adsserv.getAllStudentProfile());
		return "studentindex";  //TODO proper html page linking
	}
		
	@GetMapping("/newStudent")
	public String newStudent (Model model){
		Students student = new Students();
		model.addAttribute("student", student);
		return "create-student"; //TODO proper html page linking
	}

	@PostMapping("/newStudent")
	public String newStudent (@ModelAttribute @Valid Students student, BindingResult result, Model model){
		if (result.hasErrors()) {
			return "newStudent"; //TODO proper html page linking
		}
		adsserv.addStudent(student);
		return "studentindex";
	}

	@GetMapping("/updateStudent/{id}")
	public String updateStudent (@PathVariable(value="id") String id, Model model){
		Students student = adsserv.getStudentProfileById(id);
		model.addAttribute("student", student);
		return "updateStudent";
	}


	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable(value="id") String id, Model model){
		adsserv.deleteStudentProfileById(id);
		return "redirect:/admin/students/managestudents";
	}


	@GetMapping("/search")
	public String searchStudent(Model model,@RequestParam("searchStr") String keyword) {
		List<Students> student = adsserv.returnStudentsProfileById(keyword);
		model.addAttribute("student", student);
		return "studentindex";
	}

}
