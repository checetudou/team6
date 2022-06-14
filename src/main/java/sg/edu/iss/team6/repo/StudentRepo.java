package sg.edu.iss.team6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.edu.iss.team6.model.Students;

import java.util.ArrayList;

public interface StudentRepo extends JpaRepository<Students,String> {
    ArrayList<Students> findStudentsByStudentId(String studentId);
    //@Query
}
