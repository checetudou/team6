package sg.edu.iss.team6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team6.model.Lecturers;

import java.util.ArrayList;

public interface LecturerRepo extends JpaRepository<Lecturers,String> {
    ArrayList<Lecturers> findLecturersByLecturerId(String lecturerId);
    //@Query

	ArrayList<Lecturers> findCoursesByLecturers(String s);

    @Query("Select l from Lecturers l WHERE l.lecturerId = :sid")
	ArrayList<Lecturers> coursesByLecturer(@Param("sid") String lecturerId);
}
