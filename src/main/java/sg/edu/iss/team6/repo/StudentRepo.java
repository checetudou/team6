package sg.edu.iss.team6.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.Students;

@Repository
public interface StudentRepo extends JpaRepository<Students,String> {
      
   @Query("select c from Courses c where c not in (select c from StudentAttendCourse sac,Courses c where sac.students = :sid and sac.courses.courseId=c.courseId)")
   ArrayList<Courses> findAvailableCoursesByStudentId(@Param("sid") String studentId);

    @Query("select c from Courses c where c in (select c from StudentAttendCourse sac,Courses c where sac.students = :sid and sac.courses.courseId=c.courseId)")
    ArrayList<Students> findstudentsByStudentId(String studentId);

    @Query("Select c.size from Courses c WHERE c.courseId = :cid")
    int getCourseCapacityById(String courseId);

    @Query("Select c.actualEnroll from Courses c WHERE c.courseId = :cid")
    int getActualEnrolledById(String courseId);

    @Query("Select c from Courses c WHERE c.courseId = :cid")
    Courses findCourseByCourseId(String courseId);
    
    @Query("select c from Courses c where c in (select c from StudentAttendCourse sac,Courses c where sac.students = :sid and sac.courses.courseId=c.courseId)")
    ArrayList<Courses> findStudentByStudentId(String studentId);
    
    @Query("select s from Students s where s.Id or s.Name like %?1%")
    Courses getCurrentSize (int count);

    @Query("select s from Students s where s.Id like %?1%")
    ArrayList<Students> getStudentProfileById(String id);

    static Students saveAndFlush(String id) {
        return null;
    }
}

