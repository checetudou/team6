package sg.edu.iss.team6.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.team6.model.StudentAttendCourse;
import sg.edu.iss.team6.model.Students;
import sg.edu.iss.team6.repo.StudentAttendCourseRepo;
import sg.edu.iss.team6.repo.StudentRepo;

@Service
public class AdminStudentImpl {

	@Autowired
	private StudentRepo srepo;
	
	@Autowired
	private StudentAttendCourseRepo sacrepo;

	//student profile
	public List<Students> getAllStudentProfile(){
		return  srepo.findAll();
	}
	
	//student profile
	public Students addStudent (String id) {
		return StudentRepo.saveAndFlush(id);
	}
	//not sure how to resolve this...it says its not compatible with string?

	//student profile
	public void saveStudentProfile (Students student){
		this.srepo.save(student);
	}
	
	//student profile
	public void deleteStudentProfileById (String id){
		this.srepo.deleteById(id);
	}

	//student profile
//	@Override
	public Students getStudentProfileById (String id){
		Optional<Students> optional = srepo.findById(id);
		Students students = null;
		
		if(optional.isPresent()){
			students = optional.get();
		}
		else{
			throw new RuntimeException ("Student is not found!");
		}
		return students;
	}
	
	//student profile
	public List<Students> returnStudentProfileById(String id){
		return this.srepo.getStudentProfileById(id);
	}


	//student attend course
	public List<StudentAttendCourse>  getAllStudentInCourse(){
		return  sacrepo.findAll();
	}
	
	//student attend course
	public StudentAttendCourse getStudentById (String id) {
		Optional<StudentAttendCourse> optional = sacrepo.findById(id);
		StudentAttendCourse students = null;
	
		if(optional.isPresent()){
			students = optional.get();
		}
		else{
			throw new RuntimeException ("Student is not found!");
		}
		return students;
	}

	//student attend course
	public List<StudentAttendCourse> returnStudentById(String id){
		return this.sacrepo.getStudentById(id);
	}

	//student attend course
	public StudentAttendCourse addStudentToCourse (String id) {
		return StudentAttendCourseRepo.saveAndFlush(id);
	}

	public void saveStudentInCourse  (StudentAttendCourse student){
		this.sacrepo.save(student);
	}

	public void deleteStudentInCourseById (String id){
		this.sacrepo.deleteById(id);
	}
}

