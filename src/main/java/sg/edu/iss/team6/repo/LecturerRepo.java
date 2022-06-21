package sg.edu.iss.team6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
import org.springframework.data.repository.query.Param;
>>>>>>> main
>>>>>>> main

import sg.edu.iss.team6.model.Lecturers;

import java.util.ArrayList;

public interface LecturerRepo extends JpaRepository<Lecturers,String> {
<<<<<<< HEAD
	
	@Query("select l from Lecturers l where l.lecturerId like %?1%")
	ArrayList<Lecturers> findLecturersByLecturerName(String lecturerName);
    
=======
    ArrayList<Lecturers> findLecturersByLecturerId(String lecturerId);
    //@Query

	ArrayList<Lecturers> findCoursesByLecturers(String s);

    @Query("Select l from Lecturers l WHERE l.lecturerId = :xyz")
	ArrayList<Lecturers> coursesByLecturer(@Param("xyz") String lecturerId);
<<<<<<< HEAD
>>>>>>> 924b490 (random commit)
=======
>>>>>>> main
>>>>>>> main
}
