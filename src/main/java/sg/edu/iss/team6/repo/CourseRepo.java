package sg.edu.iss.team6.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sg.edu.iss.team6.model.Courses;


@Repository
public interface CourseRepo extends JpaRepository<Courses,String> {
    
	@Query("SELECT c FROM Courses c WHERE c.courseName LIKE :cname")
    List<Courses> findCoursesByCourseName(@Param("cname") String cname);

    @Query("SELECT c FROM Courses c WHERE c.courseId LIKE :cid")
	List<Courses> findCoursesByCourseId(@Param("cid") String id);

	@Query("SELECT c FROM Courses c WHERE c.courseId = :cid")
	Courses findCourseByCourseId(@Param("cid") String id);
  
    @Query("SELECT sac.courses FROM StudentAttendCourse sac WHERE sac.students.studentId = :sid")
	ArrayList<Courses> findCoursesByStudentId(@Param("sid") String studentId);

	@Query("SELECT c.size FROM Courses c where c.courseId = :cid")
	int getAllowedSize (@Param("cid") String courseId);

	List<Courses> findAll();

	// Not required; Just call saveAndFlush method
	// @Query("insert c into Courses c values(:courses.courseId,courses.courseName,courses.size,"
	// 	+ "courses.actualEnroll,courses.description)")
	// void addCourse(Courses courses);

	// @Query("update Courses set(:courses.courseName,courses.size,"
	// 	+ "courses.actualEnroll,courses.description) where courses.courseId = courseId")
	// void updateCourse(Courses course);

	//List<Courses> getAllCourses(Pageable pageable);
	
	//Pageable firstPageWithTenElements = PageRequest.of(0, 10);
	//https://www.baeldung.com/spring-data-jpa-pagination-sorting
}
