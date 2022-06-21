package sg.edu.iss.team6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team6.model.*;

import java.util.ArrayList;

public interface CourseRepo extends JpaRepository<Courses,Integer> {
    @Query("Select c from Courses c WHERE c.courseId = :cid")
    ArrayList<Courses> findCoursesByCourseId(@Param("cid") String cid);

    @Query("Select lc from LectureCanTeach lc WHERE lc.lecturers.lecturerId = :lid")
	ArrayList<LectureCanTeach> findCoursesByLecturerId(@Param("lid") String lecturerId);
    
    @Query("select c from StudentAttendCourse sac,Courses c where sac.students = :sid and sac.courses.courseId=c.courseId")
	ArrayList<StudentAttendCourse> findCoursesByStudentId(@Param("sid") String studentId);
    
 
}
