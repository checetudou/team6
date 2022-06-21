package sg.edu.iss.team6.repo;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.StudentAttendCourse;


@Repository
public interface StudentAttendCourseRepo extends JpaRepository<StudentAttendCourse,String> {

	@Query("select COUNT students from StudentAttendCourse sac where sac.courseId like %?1%")
	Courses getCurrentSize (int count);
	
	static StudentAttendCourse saveAndFlush(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	List<StudentAttendCourse> getStudentById(String id, Pageable pageable);
}

//
//@Query("select s from Students s where s.Id or s.Name like %?1%")
//StudentAttendCourse getAllowedSize (int count);
//
//List<StudentAttendCourse> getStudentById(String id);
//
//@Query("Update StudentCanAttend set courseId = :cid")
//void saveCourse(@Param("cid")String courseId) ;
