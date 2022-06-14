package sg.edu.iss.team6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.edu.iss.team6.model.Lecturers;

import java.util.ArrayList;

public interface LecturerRepo extends JpaRepository<Lecturers,String> {
    ArrayList<Lecturers> findLecturersByLecturerId(String lecturerId);
    //@Query
}
