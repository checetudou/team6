package sg.edu.iss.team6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.team6.model.Students;

@Controller
public class ToBeDeletedAdminManageStudent {

	@Autowired
	private ToBeDeletedAdminManageStudent adsserv;
	
//	@RequestMapping(“/”)
//	public String homePage (Model model){
//		model.addAttribute(“adminAccess”, adserv.getAdminAccess);
//		return “index”;  (index page should contain links to the different functions)
//	}

	@RequestMapping("/student")
	public String allStudentsPage (Model model){
		model.addAttribute("listStudent", adsserv.getAllStudents());
		return "studentindex";  
	}

	private Object getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/newStudent")
	public String newStudent (Model model){
		Students student = new Students();
		model.addAttribute("student", student);
		return "newStudent";
	}

	@PostMapping("/saveStudent")
	public String saveStudent (@ModelAttribute("student") Students student){
		adsserv.saveStudent (student);
		return "redirect:/";
	}

	// includes editing the student's grade
	@GetMapping("/updateStudent/{id}")
	public String updateStudent (@PathVariable(value="id") String id, Model model){
		Students student = adsserv.getStudentById(id);
		model.addAttribute("student", student);
		return "updateStudent";
	}

	private Students getStudentById(java.lang.String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable(value="id") String id, Model model){
		adsserv.deleteStudentById(id);
		return "redirect:/";
	}

	private void deleteStudentById(java.lang.String id) {
		// TODO Auto-generated method stub
		
	}


}
