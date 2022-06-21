package sg.edu.iss.team6.repo;

import java.util.ArrayList;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.model.Students;


public interface UserRepo extends JpaRepository<Lecturers, String> {

	@Query("SELECT s FROM Students s  WHERE s.studentId=:stuid")
	Students findStudentBystuID(@Param("stuid") String stuid);
	
	@Query("SELECT l FROM Lecturers l  WHERE l.lecturerId=:lecid")
	Lecturers findLecturerBylecID(@Param("lecid") String lecid);
}
