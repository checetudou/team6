package sg.edu.iss.team6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
<<<<<<< HEAD
=======

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sg.edu.iss.team6.model.Courses;
=======
>>>>>>> main
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team6.model.*;
<<<<<<< HEAD
=======

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sg.edu.iss.team6.model.Courses;
>>>>>>> b3cac0a (srepo, sacrepo)

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
=======
>>>>>>> main

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
@Repository
public interface CourseRepo extends JpaRepository<Courses,String> {
    
	@Query("select c from Courses c where c.courseId like %?1%")
	List<Courses> findCoursesByCourseId(String courseId);
    
//	@Query("select c from Courses c where c.courseName like %?1%")
//    List<Courses> findCoursesByCourseName(String courseName);
		
	@Query("select c.size from Courses c where c.courseId like %?1%")
	Courses getAllowedSize (int count);

	Optional<Courses> findByName(String name);
    
	
=======
>>>>>>> main
public interface CourseRepo extends JpaRepository<Courses,Integer> {
    @Query("Select c from Courses c WHERE c.courseId = :cid")
    ArrayList<Courses> findCoursesByCourseId(@Param("cid") String cid);

    @Query("Select lc from LectureCanTeach lc WHERE lc.lecturers.lecturerId = :lid")
	ArrayList<LectureCanTeach> findCoursesByLecturerId(@Param("lid") String lecturerId);
    
    @Query("select c from StudentAttendCourse sac,Courses c where sac.students = :sid and sac.courses.courseId=c.courseId")
	ArrayList<StudentAttendCourse> findCoursesByStudentId(@Param("sid") String studentId);
    
    
 
<<<<<<< HEAD
=======
@Repository
public interface CourseRepo extends JpaRepository<Courses,String> {
    
	@Query("select c from Courses c where c.courseId like %?1%")
	List<Courses> findCoursesByCourseId(String courseId);
    
//	@Query("select c from Courses c where c.courseName like %?1%")
//    List<Courses> findCoursesByCourseName(String courseName);
		
	@Query("select c.size from Courses c where c.courseId like %?1%")
	Courses getAllowedSize (int count);

	Optional<Courses> findByName(String name);
    
	
>>>>>>> b3cac0a (srepo, sacrepo)
=======
>>>>>>> main
>>>>>>> main
}
