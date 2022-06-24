package sg.edu.iss.team6.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.repo.LecturerRepo;

@Service
public class LecturerServiceImpl implements LecturerService{
	
	@Resource
	private LecturerRepo lecRepo;

	@Override
	public ArrayList<Courses> coursesByLecturer(String lecturerid) {
		return lecRepo.findCoursesByLecturer(lecturerid);
	}

	@Override
	public ArrayList<Lecturers> findAllLecturers() {
		return (ArrayList<Lecturers>) lecRepo.findAll();
	}

	@Override
	public Lecturers findLecturer(String lecturerId) {
		return lecRepo.findLecturerByLecturerId(lecturerId);
	}

	@Override
	public void createLecturer(Lecturers lecturer) {
		lecRepo.saveAndFlush(lecturer);		
	}

	@Override
	public void removeLecturer(Lecturers lecturer) {
		lecRepo.delete(lecturer);
	}

	@Override
	public void updateLecturer(Lecturers lecturer) {
		lecRepo.saveAndFlush(lecturer);	
	}

	@Override
	public void updateGradesByCourseidAndUserid(String courseid,String studentid,String grade){
		lecRepo.updateGradesByCourseidAndUserid(courseid,studentid,grade);
	}

}
