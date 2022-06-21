package sg.edu.iss.team6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.team6.model.Lecturers;

@Controller
public class ToBeDeletedAdminManageLecturer {

	@Autowired
	private ToBeDeletedAdminManageLecturer adlserv;
	
//	@RequestMapping("/")
//	public String homePage (Model model){
//		model.addAttribute("adminAccess", adserv.getAdminAccess);
//		return "index";  //index page should contain links to the different functions
//	}
	
	@RequestMapping("/lecturer")
	public String allLecturersPage (Model model){
		model.addAttribute("listLecturer", adlserv.getAllLecturers());
		return "lecturerindex"; 
	}

	private Object getAllLecturers() {
	// TODO Auto-generated method stub
	return null;
}

	@GetMapping("/newLecturer")
	public String newLecturer (Model model){
		Lecturers lecturer = new Lecturers();
		model.addAttribute("lecturer", lecturer);
		return "newLecturer";
	}

	@PostMapping("/saveLecturer")
	public String saveLecturer (@ModelAttribute("lecturer") Lecturers lecturer){
		adlserv.saveLecturer(lecturer);
		return "redirect:/";
	}

	@GetMapping("/updateLecturer/{name}")
	public String updateLecturer (@PathVariable(value="name") String name, Model model){
		Lecturers lecturer = adlserv.getLecturerByName(name);
		model.addAttribute("lecturer", lecturer);
		return "updateLecturer";
	}

	private Lecturers getLecturerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/deleteLecturer/{name}")
	public String deleteStudent(@PathVariable(value="name") String name, Model model){
		adlserv.deleteLecturerByName(name);
		return "redirect:/";
	}

	private void deleteLecturerByName(String name) {
		// TODO Auto-generated method stub
		
	}

}
