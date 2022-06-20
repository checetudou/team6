package sg.edu.iss.team6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.Students;

import java.util.ArrayList;
import java.util.List;

public interface StudentRepo extends JpaRepository<Students,String> {
    
	@Query("select s from Students s where s.Id like %?1%")
	ArrayList<Students> findStudentsByStudentId(String studentId);
    
	@Query("select s from Students s where s.Name like %?1%")
    List<Students> findStudentsByStudentName(String Name);
	
	@Query("select s from Students s where s.Id or s.Name like %?1%")
	Courses getCurrentSize (int count);

	List<Students> getStudentById(String id);
		
}
