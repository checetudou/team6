package sg.edu.iss.team6.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sg.edu.iss.team6.model.Courses;
import sg.edu.iss.team6.model.Lecturers;

@Repository
public interface LecturerRepo extends JpaRepository<Lecturers,String> {

    @Query("SELECT l FROM Lecturers l WHERE l.lecturerId LIKE :lid")
    ArrayList<Lecturers> findLecturersByLecturerId(@Param("lid") String lecturerid);

    @Query("SELECT l FROM Lecturers l WHERE l.lecturerId = :lid")
    Lecturers findLecturerByLecturerId(@Param("lid") String lecturerid);

    @Query("SELECT lct.courses FROM LectureCanTeach lct WHERE lct.lecturers.lecturerId=:lid")
    ArrayList<Courses> findCoursesByLecturer(@Param("lid") String lecturerid);

    @Query("update StudentAttendCourse s set s.grade=:grade where s.courses.courseId=:cid and s.students.studentId=:sid")
    void updateGradesByCourseidAndUserid(@Param("cid") String courseid, @Param("sid") String studentid, @Param("g") String grade);
}

