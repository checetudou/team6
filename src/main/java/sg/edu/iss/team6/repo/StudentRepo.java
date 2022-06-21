package sg.edu.iss.team6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.model.StudentAttendCourse;
import sg.edu.iss.team6.model.Students;

import java.util.ArrayList;

public interface StudentRepo extends JpaRepository<Students,String> {
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