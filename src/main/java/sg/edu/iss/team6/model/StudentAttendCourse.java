package sg.edu.iss.team6.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student_attend_course")
@Data
@NoArgsConstructor
public class StudentAttendCourse implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "studentId")
    private Students students;

    @Id
    @ManyToOne
    @JoinColumn(name = "courseId")
    private Courses courses;

    private double grade;

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public StudentAttendCourse(Students students, Courses courses, double grade) {
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
