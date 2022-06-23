package sg.edu.iss.team6.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.edu.iss.team6.helper.GradeEnum;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student_attend_course")
@Data
@NoArgsConstructor
@IdClass(StudentAttendCourseId.class)
public class StudentAttendCourse implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "studentId")
    private Students students;

    @Id
    @ManyToOne
    @JoinColumn(name = "courseId")
    private Courses courses;

    private GradeEnum grade;

    public StudentAttendCourse(Students students, Courses courses, GradeEnum grade) {
        this.students = students;
        this.courses = courses;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentAttendCourse{" +
                "students=" + students +
                ", courses=" + courses +
                ", grade=" + grade +
                '}';
    }
}
