package sg.edu.iss.team6.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sg.edu.iss.team6.model.Lecturers;

@Repository
public interface LecturerRepo extends JpaRepository<Lecturers,String> {

    //ArrayList<Lecturers> findLecturersByLecturerId(String lecturerId);

    //@Query("select c from LectureCanTeach lct,Courses c where lct = :lid and lct.courses.courseId=c.courseId")
    
    //@Query("select courseId from LectureCanTeach lct where lct.lecturers.lecturerId = :lid")
    
    //ArrayList<Courses> findCoursesByLecturers(@Param("lid") String s);
  
    @Query("Select l from Lecturers l WHERE l.lecturerId = :xyz")
	ArrayList<Lecturers> coursesByLecturer(@Param("xyz") String lecturerId);

}
