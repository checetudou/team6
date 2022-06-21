package sg.edu.iss.team6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
<<<<<<< HEAD

import sg.edu.iss.team6.model.Courses;
=======
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.model.StudentAttendCourse;
>>>>>>> main
import sg.edu.iss.team6.model.Students;

import java.util.ArrayList;
import java.util.List;

public interface StudentRepo extends JpaRepository<Students,String> {
<<<<<<< HEAD
    
	@Query("select s from Students s where s.Id like %?1%")
	ArrayList<Students> findStudentsByStudentId(String studentId);
    
	@Query("select s from Students s where s.Name like %?1%")
    List<Students> findStudentsByStudentName(String Name);
	
	@Query("select s from Students s where s.Id or s.Name like %?1%")
	Courses getCurrentSize (int count);

	List<Students> getStudentById(String id);
		
}
=======
    //@Query
    ArrayList<Students> findstudentsByStudentId(String studentId);
    
    
       
       @Query("Select c from Courses c WHERE c.StudentAttendCourse.students.studentId != :sid")
       ArrayList<Courses> findAvailableCoursesByStudentId(String studentId);
       
       @Query("Select c.size from Courses c WHERE c.courseId == :cid")
       int getCourseCapacityById(String courseId);
       
       @Query("Select c.actualEnroll from Courses c WHERE c.courseId == :cid")
       int getActualEnrolledById(String courseId);
       
       @Query("Select c from Courses c WHERE c.courseId == :cid")
       Courses findCourseByCourseId(String courseId);
}
>>>>>>> main
