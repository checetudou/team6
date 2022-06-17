package sg.edu.iss.team6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team6.model.*;

import java.util.ArrayList;

public interface CourseRepo extends JpaRepository<Courses,Integer> {
    @Query("Select c from Courses WHERE c.CourseId = :cid")
    ArrayList<Courses> findCoursesByCourseId(@Param("cid") Integer cid);

    @Query("Select lc from LectureCanTeach WHERE lc.LecturerId = :lid")
	ArrayList<LectureCanTeach> findCoursesByLecturerId(@Param("lid") Integer lecturerId);
    
    @Query("Select sc from StudentAttendCourse WHERE sc.studentId = :sid")
	ArrayList<StudentAttendCourse> findCoursesByStudentId(@Param("sid") Integer lecturerId);
}
