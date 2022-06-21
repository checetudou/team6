package sg.edu.iss.team6.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.StudentAttendCourse;
import sg.edu.iss.team6.model.Students;
import sg.edu.iss.team6.repo.CourseRepo;

@Service
public abstract class AdminCourseImpl implements AdminCourse {
	
	@Autowired
	private CourseRepo crepo;

	@Override
	public List<Courses> getAllCourses(){
		return crepo.findAll();
	}

	@Override
	public void saveCourses (Courses courses){
		this.crepo.save(courses);
	}

	@Override
	public Courses getCoursesById (String Id){
		Optional<Courses> optional = crepo.findById(Id);
		Courses courses = null;
		
		if(optional.isPresent()){
			courses = optional.get();
		}
		else{
			throw new RuntimeException("Course is not found!");
		}
		return courses;
	}
	
	@Transactional 
	
	@Override
	public List<Courses> returnCourseById(String courseId){
		return this.crepo.findCoursesByCourseId(courseId);
	}

	@Override
	public Courses getCoursesByName (String Name){
		Optional<Courses> optional = crepo.findByName(Name);
		Courses courses = null;
		
		if(optional.isPresent()){
			courses = optional.get();
		}
		else{
			throw new RuntimeException ("Course is not found!");
		}
		return courses;
	}
	
	@Override
	public List<Courses> returnCourseByName(String name){
		return this.crepo.findCoursesByCourseName(name);
	}

}



