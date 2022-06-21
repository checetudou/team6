package sg.edu.iss.team6.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.repo.CourseRepo;
import sg.edu.iss.team6.repo.StudentAttendCourseRepo;

@Service
public class AdminCourseImpl implements AdminCourse {
	
	@Autowired
	private CourseRepo crepo;
	
	@Autowired
	private StudentAttendCourseRepo sacrepo;


	@Override
	public List<Courses> getAllCourses(){
		return crepo.findAll();
	}


	public Courses getCourseById (String courseId){
		Optional<Courses> optional = crepo.findById(courseId);
		Courses courses = null;
		
		if(optional.isPresent()){
			courses = optional.get();
		}
		else{
			throw new RuntimeException("Course is not found!");
		}
		return courses;
	}
	
	@Override
	@Transactional
	public List<Courses> returnCourseById(String courseId){
		return this.crepo.getCourseById(courseId);
	}

	@Override
	public void deleteCourse (String courseId){
		this.crepo.deleteById(courseId);
	}

	
	@Override
	public void saveCourse(Courses courses){
		this.crepo.save(courses);
	}
	
	@Override
	public void addCourse(Courses courses){
		this.crepo.addCourse(courses);
	}


	@Override
	public void updateCourse(Courses courses) {
		// TODO Auto-generated method stub
		this.crepo.updateCourse(courses);
	}


}

