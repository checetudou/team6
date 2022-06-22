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
import sg.edu.iss.team6.services.AdminLecturer;

@Controller
public class Admin_Lecturer {


	@Autowired
	private AdminLecturer adlserv;
		
	
// upon clicking manage lecturers, I should see a list of lecturers
	@RequestMapping("/managelecturers")
	public String allLecturersPage (Model model){
		model.addAttribute("listLecturer", adlserv.getAllLecturer());
		return "lecturerindex"; 
	}	

	
// creating a new Lecturer, this should return a form to add in details.
// After which, it should return the list of lecturers with the new addition.	
	@GetMapping("/newLecturer")
	public String newLecturer (Model model){
		Lecturers lecturer = new Lecturers();
		model.addAttribute("lecturer", lecturer);
		return "newLecturer"; //redirecting html page
	}

	@GetMapping("/updateLecturer/{lecturerId}")
	public String updateLecturer (@PathVariable(value="lecturerId") String lecturerId, Model model){
		Lecturers lecturer = adlserv.getLecturer(lecturerId);
		model.addAttribute("lecturer", lecturer);
		return "updateLecturer";
	}

	@GetMapping("/deleteLecturer/{lecturerId}")
	public String deleteLecturer(@PathVariable(value="lecturerId") String lecturerId, Model model){
		adlserv.deleteLecturerById (lecturerId);
		return "redirect:/managelecturers";
	}

	private void deleteLecturer(String lecturerId) {
		// TODO Auto-generated method stub
		
	}

	@PostMapping("/saveLecturer")
	public String saveLecturer (@ModelAttribute("lecturer") Lecturers lecturer){
		adlserv.saveLecturer(lecturer);
		return "redirect:/managelecturers";
	}
	
	@PostMapping("/search")
	public String searchLecturer(@Param("lecturerId")String lecturerId, Model model) {
		List<Lecturers>lecturer = adlserv.returnLecturerById(lecturerId);
		model.addAttribute("lecturer", lecturer);
		return "managelecturers";
	}
	
}
