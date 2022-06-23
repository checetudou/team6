package sg.edu.iss.team6.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.repo.LecturerRepo;

@Service
public class AdminLecturerImpl implements AdminLecturer{

	@Resource
	private LecturerRepo lrepo;
	
	@Override
	public ArrayList<Lecturers> getAllLecturers() {
		return (ArrayList<Lecturers>) lrepo.findAll();
	}

	@Override
	public void addLecturer(Lecturers lecturer) {
		lrepo.saveAndFlush(lecturer);
	}

	@Override
	public Lecturers getLecturer(String id) {
		return lrepo.findLecturerByLecturerId(id);
	}

	@Override
	public void saveLecturer(Lecturers lecturer) {
		lrepo.saveAndFlush(lecturer);
	}

	@Override
	public void deleteLecturerById(String lecturerId) {
		Lecturers l = lrepo.findLecturerByLecturerId(lecturerId);
		lrepo.delete(l);
	}

	@Override
	public ArrayList<Lecturers> getLecturersById(String lecturerid) {
		return getLecturersById(lecturerid);
	}

}
