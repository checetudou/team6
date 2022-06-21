package sg.edu.iss.team6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team6.model.*;

import java.util.ArrayList;

public interface CourseRepo extends JpaRepository<Courses,String> {
    @Query("Select c from Courses c WHERE c.courseId = :cid")
    ArrayList<Courses> findCoursesByCourseId(@Param("cid") String cid);
//
//    @Query("Select lc from LectureCanTeach lc WHERE lc.lecturers.lecturerId = :lid")
//	ArrayList<LectureCanTeach> findCoursesByLecturerId(@Param("lid") String lecturerId);
    
    @Query("Select sc from StudentAttendCourse sc WHERE sc.students.studentId = :sid")
	ArrayList<StudentAttendCourse> findCoursesByStudentId(@Param("sid") String studentId);

    @Query("select c from LectureCanTeach sac,Courses c where sac.lecturers.lecturerId = :lid and sac.courses.courseId=c.courseId")
    ArrayList<Courses> findCoursesByLecturerId(@Param("lid") String lecturerId);
    
 
}
