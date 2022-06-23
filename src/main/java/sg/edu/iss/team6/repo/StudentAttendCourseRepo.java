package sg.edu.iss.team6.repo;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sg.edu.iss.team6.model.StudentAttendCourse;


@Repository
public interface StudentAttendCourseRepo extends JpaRepository<StudentAttendCourse,String> {

	@Query("SELECT COUNT(students) FROM StudentAttendCourse sac WHERE sac.coursescourseId=:cid")
	int getCurrentSize (@Param("cid")String courseid);
	
	@Query("SELECT c.size FROM Courses c WHERE c.courseId=:cid")
	int getAllowedSize (@Param("cid")String courseid);

	@Query("SELECT sac FROM StudentAttendCourse sac WHERE sac.students.studentId=:sid")
	List<StudentAttendCourse> getStudentAttendCourseListByStudentId(@Param("sid")String studentId);

	List<StudentAttendCourse> getStudentById(String id, Pageable pageable);
}
