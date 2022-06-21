package sg.edu.iss.team6.repo;

import java.util.ArrayList;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.model.Students;


public interface UserRepo extends JpaRepository<Lecturers, String> {

	@Query("SELECT Students s FROM Students  WHERE s.studentId=:stuid")
	ArrayList<Students> findStudentBystuID(@Param("stuid") String stuid);
	
	@Query("SELECT Lecturers l FROM Lecturers  WHERE s.lecturerId=:lecid")
	ArrayList<Lecturers> findLecturerBylecID(@Param("lecid") String lecid);
}
