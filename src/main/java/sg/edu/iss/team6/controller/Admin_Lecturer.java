package sg.edu.iss.team6.controller;

import java.util.ArrayList;

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

import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.services.AdminLecturer;

@Controller
@RequestMapping(value = "/admin/lecturers")
public class Admin_Lecturer {

	@Autowired
	private AdminLecturer adlserv;
		
	@GetMapping("/managelecturers")
	public String allLecturersPage (Model model){
		model.addAttribute("listLecturer", adlserv.getAllLecturers());
		return "admin-lecturer_lecturerlist"; //TODO Proper html page linking
	}	

	@GetMapping("/newLecturer")
	public String newLecturer (Model model){
		Lecturers lecturer = new Lecturers();
		model.addAttribute("lecturer", lecturer);
		return "admin-lecturer_addlecturer"; //TODO linking proper html pages
	}

	@PostMapping("/newLecturer")
	public String newedLecturer (@ModelAttribute @Valid Lecturers lecturer, BindingResult result, Model model){
		if (result.hasErrors()) {
			return "admin-lecturer_addlecturer"; //TODO proper html page linking
		}
		adlserv.addLecturer(lecturer);
		return admin-lecturer_lecturerlist"; //TODO linking proper html pages
	}

	@GetMapping("/updateLecturer/{lecturerId}")
	public String updateLecturer (@PathVariable(value="lecturerId") String lecturerId, Model model){
		Lecturers lecturer = adlserv.getLecturer(lecturerId);
		model.addAttribute("lecturer", lecturer);
		return "updateLecturer"; //TODO linking proper html page
	}

	@PostMapping("/updateLecturer/{lecturerId}")
	public String updatingLecturer (@ModelAttribute("lecturer") @Valid Lecturers lecturer, BindingResult result,Model model){
		if (result.hasErrors()) {
			return "updateLecturer";
		} 
		else {
			adlserv.saveLecturer(lecturer);
		}
		return "redirect:/managelecturers"; //TODO linking proper html page
	}

	@GetMapping("/deleteLecturer/{lecturerId}")
	public String deleteLecturer(@PathVariable(value="lecturerId") String lecturerId, Model model){
		adlserv.deleteLecturerById(lecturerId);
		return "redirect:/managelecturers"; //TODO proper html pages
	}
	
	@PostMapping("/search")
	public String searchLecturer(@Param("lecturerId")String lecturerId, Model model) {
		ArrayList<Lecturers> lecturerss = adlserv.getLecturersById(lecturerId);
		model.addAttribute("lecturer", lecturerss);
		return "managelecturers"; //TODO proper html page linking
	}
	
}
