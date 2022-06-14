package sg.edu.iss.team6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.edu.iss.team6.model.Courses;

import java.util.ArrayList;

public interface CourseRepo extends JpaRepository<Courses,String> {
    ArrayList<Courses> findCoursesByCourseId(String courseId);
    //@Query
}
