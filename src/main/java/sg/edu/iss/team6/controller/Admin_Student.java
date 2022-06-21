package sg.edu.iss.team6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.model.Students;
import sg.edu.iss.team6.services.AdminStudent;

@Controller
public class Admin_Student {


	@Autowired
	private AdminStudent adsserv;
	
	// upon clicking manage students, I should see a list of students
	@RequestMapping("/managestudents")
	public String getAllStudentProfile (Model model){
		model.addAttribute("listStudent", adsserv.getAllStudents());
		return "studentindex";  
	}

	private Object getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

// creating a new Lecturer, this should return a form to add in details.
// After which, it should return the list of lecturers with the new addition.	
	@GetMapping("/newStudent")
	public String newStudent (Model model){
		Students student = new Students();
		model.addAttribute("student", student);
		return "newStudent";
	}

	@GetMapping("/updateStudent/{id}")
	public String updateStudent (@PathVariable(value="id") String id, Model model){
		Students student = adsserv.getStudentProfileById(id);
		model.addAttribute("student", student);
		return "updateStudent";
	}

	private Students getStudentProfileById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable(value="id") String id, Model model){
		adsserv.deleteStudentProfileById(id);
		return "redirect:/managestudents";
	}

	private void deleteStudentProfileById(String id) {
		// TODO Auto-generated method stub
		
	}

	@PostMapping("/search")
	public String searchStudent(@Param("id")String id, Model model) {
		List<Students> student = adsserv.returnStudentProfileById(id);
		model.addAttribute("student", student);
		return "managestudents";
	}

	private List<Students> returnStudentProfileById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping("/saveStudent")
	public String saveStudent (@ModelAttribute("student") Students student){
		adsserv.saveStudent (student);
		return "redirect:/managestudents";
	}
}
