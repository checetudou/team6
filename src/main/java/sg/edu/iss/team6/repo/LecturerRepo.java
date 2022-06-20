package sg.edu.iss.team6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.edu.iss.team6.model.Lecturers;

import java.util.ArrayList;

public interface LecturerRepo extends JpaRepository<Lecturers,String> {
	
	@Query("select l from Lecturers l where l.lecturerId like %?1%")
	ArrayList<Lecturers> findLecturersByLecturerName(String lecturerName);
    
}
