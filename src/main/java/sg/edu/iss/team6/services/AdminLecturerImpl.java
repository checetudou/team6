package sg.edu.iss.team6.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.repo.LecturerRepo;

@Service
public class AdminLecturerImpl implements AdminLecturer{

	@Autowired
	private LecturerRepo lrepo;
	
	@Override
	public List<Lecturers> getAllLecturer(){
		return lrepo.findAll();
	}
	
	@Override
	public Lecturers getLecturerById(String lecturerId) {
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
	public List<Lecturers> returnLecturerById (String lecturerId){
		return this.lrepo.findLecturersByLectureId(lecturerId);
	}

	@Override
	public Lecturers getLecturer(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
