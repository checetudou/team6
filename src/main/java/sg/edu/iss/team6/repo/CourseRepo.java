package sg.edu.iss.team6.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sg.edu.iss.team6.model.Courses;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Courses,String> {
    
	@Query("select c from Courses c where c.courseId like %?1%")
	List<Courses> findCoursesByCourseId(String courseId);
    
//	@Query("select c from Courses c where c.courseName like %?1%")
//    List<Courses> findCoursesByCourseName(String courseName);
		
	@Query("select c.size from Courses c where c.courseId like %?1%")
	Courses getAllowedSize (int count);

	Optional<Courses> findByName(String name);
    
	
}
