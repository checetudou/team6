package sg.edu.iss.team6.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.team6.model.StudentAttendCourse;
import sg.edu.iss.team6.model.Students;
import sg.edu.iss.team6.repo.StudentAttendCourseRepo;
import sg.edu.iss.team6.repo.StudentRepo;

@Service
public class AdminStudentImpl implements AdminStudent{

	@Autowired
	private StudentRepo srepo;
	
	@Autowired
	private StudentAttendCourseRepo sacrepo;

	@Override
	public List<Students> getAllStudentProfile(){
		return srepo.findAll();
	}
	
	@Override
	public void addStudent(Students student) {
		srepo.saveAndFlush(student);
	}

	@Override
	public void saveStudentProfile (Students student){
		this.srepo.save(student);
	}
	
	@Override
	public void deleteStudentProfileById (String id){
		this.srepo.deleteById(id);
	}

	@Override
	public Students getStudentProfileById(String id){
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

	public ArrayList<Students> getStudentsProfileById(String id){
		return srepo.findstudentsByStudentId(id);
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
	
	public void saveStudentInCourse (StudentAttendCourse student){
		this.sacrepo.save(student);
	}

	public void deleteStudentInCourseById (String id){
		this.sacrepo.deleteById(id);
	}

	@Override
	public void updateStudent(Students student) {
		// TODO Auto-generated method stub
		// no need return anything if just adding to table right
	}

	@Override
	public StudentAttendCourse addStudentToCourse(String courseId) {
		// TODO 
		// no need return anything if just adding to table right
		return null;
	}
}

