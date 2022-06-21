package sg.edu.iss.team6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.model.Students;
import sg.edu.iss.team6.repo.LecturerRepo;

public class AdminLecturerImpl {

	@Autowired
	private LecturerRepo lrepo;
	
	@Override
	public List<Lecturers> getAllLecturer(){
		return  lrepo.findAll();
	}
	
	@Override
	public Lecturers getLecturerById (String lecturerId) {
		Optional<Lecturers> optional = lrepo.findById(lecturerId);
		Lecturers lecturers = null;
		
		if(optional.isPresent()){
			lecturers = optional.get();
		}
		else{
			throw new RuntimeException ("Lecturer is not found!");
		}
		return lecturers;
	}
	
	@Override
	public void saveLecturer (Lecturers lecturer) {
		this.lrepo.save(lecturer);
	}
	
	@Override
	public void deleteLecturerById (String lecturerId) {
		this.lrepo.deleteById(lecturerId);
	}
	
	@Override
	List<Lecturers> returnLecturerById (String lecturerId){
		return this.lrepo.getLecturerById(lecturerId);
	}


	
}
