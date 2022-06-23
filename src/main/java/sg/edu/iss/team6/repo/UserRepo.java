package sg.edu.iss.team6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.model.Students;

@Repository
public interface UserRepo extends JpaRepository<Lecturers, String> {

	@Query("SELECT s FROM Students s WHERE s.studentId=:stuid")
	Students findStudentBystuID(@Param("stuid") String stuid);
	
	@Query("SELECT l FROM Lecturers l WHERE l.lecturerId=:lecid")
	Lecturers findLecturerBylecID(@Param("lecid") String lecid);
}
