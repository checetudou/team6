package sg.edu.iss.team6.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.Students;

@Repository
public interface StudentRepo extends JpaRepository<Students,String> {
      
    @Query("SELECT c FROM Courses c WHERE c NOT IN (SELECT sac.courses FROM StudentAttendCourse sac WHERE sac.students.studentId = :sid)")
    ArrayList<Courses> findAvailableCoursesByStudentId(@Param("sid") String studentId);

    @Query("SELECT s FROM students s WHERE s.studentId LIKE :sid")
    ArrayList<Students> findstudentsByStudentId(@Param("sid") String studentId);

    @Query("Select c.actualEnroll from Courses c WHERE c.courseId = :cid")
    int getActualEnrolledById(String courseId);

    @Query("SELECT c FROM Courses c WHERE c.courseId = :cid")
    Courses findCourseByCourseId(@Param("cid") String courseId);        
  
    @Query("SELECT c.size FROM Courses c WHERE c.courseId = :cid") 
    int getCourseCapacityById(@Param("cid") String courseId);
	
	List<Students> getAllStudentProfile(Pageable pageable);

}

