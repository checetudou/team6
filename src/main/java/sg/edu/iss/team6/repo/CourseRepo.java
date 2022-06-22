package sg.edu.iss.team6.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.StudentAttendCourse;


@Repository
public interface CourseRepo extends JpaRepository<Courses,String> {
    
	@Query("select c from Courses c where c.courseName like %?1%")
    List<Courses> findCoursesByCourseName(String courseName);

//    @Query("Select lc from LectureCanTeach lc WHERE lc.lecturers.lecturerId = :lid")
//	ArrayList<LectureCanTeach> findCoursesByLecturerId(@Param("lid") String lecturerId);
    
    @Query("select c from StudentAttendCourse sac,Courses c where sac.students = :sid and sac.courses.courseId=c.courseId")
	ArrayList<StudentAttendCourse> findCoursesByStudentId(@Param("sid") String studentId, Pageable pageable);

    @Query("select c from LectureCanTeach sac,Courses c where sac.lecturers.lecturerId = :lid and sac.courses.courseId=c.courseId")
    ArrayList<Courses> findCoursesByLecturerId(@Param("lid") String lecturerId, Pageable pageable);
    
	@Query("select c from Courses c where c.courseId like %?1%")
	List<Courses> findCoursesByCourseId(String courseId);
    
		
	@Query("select c.size from Courses c where c.courseId like %?1%")
	Courses getAllowedSize (int count);

	Optional<Courses> findByName(String name);

	@Query("select c from Courses c where c.courseId like %?1%")
	List<Courses> getCourseById(String courseId);

	@Query("insert c into Courses c values(:courses.courseId,courses.courseName,courses.size,"
		+ "courses.actualEnroll,courses.description)")
	void addCourse(Courses courses);

	@Query("update Courses set(:courses.courseName,courses.size,"
		+ "courses.actualEnroll,courses.description) where courses.courseId = courseId")
	void updateCourse(Courses course);

	List<Courses> getAllCourses(Pageable pageable);
	
	//Pageable firstPageWithTenElements = PageRequest.of(0, 10);
	//https://www.baeldung.com/spring-data-jpa-pagination-sorting
}
