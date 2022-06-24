package sg.edu.iss.team6.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sg.edu.iss.team6.model.LectureCanTeach;


@Repository
public interface LecturerCanTeachRepo extends JpaRepository<LectureCanTeach,String> {

    @Query("SELECT COUNT(lct.courses) FROM LectureCanTeach lct WHERE lct.lecturers.lecturerId=:lid")
    int getCourses (@Param("lid")String lecturerId);

    @Query("SELECT lct FROM LectureCanTeach lct WHERE lct.lecturers.lecturerId=:lid")
    List<LectureCanTeach> getLectureCanTeachListByLecturerId(@Param("lid")String lecturerId);

    @Query("SELECT lct FROM LectureCanTeach lct WHERE lct.courses.courseId=:cid")
    List<LectureCanTeach> getLectureCanTeachListByCourseId(@Param("cid")String courseId);

    @Query("SELECT lct FROM LectureCanTeach lct WHERE lct.courses.courseId=:cid AND lct.lecturers.lecturerId=:lid")
    LectureCanTeach getLectureCanTeachByCourseIdAndLecturerId(@Param("cid")String courseId, @Param("lid")String lecturerId);
}