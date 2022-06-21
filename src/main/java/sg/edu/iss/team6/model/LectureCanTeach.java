package sg.edu.iss.team6.model;

import lombok.Data;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "lecture_can_teach")
public class LectureCanTeach implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "lecturerId")
    private Lecturers lecturers;

    @Id
    @ManyToOne
    @JoinColumn(name = "courseId")
    private Courses courses;

    public Lecturers getLecturers() {
        return lecturers;
    }

    public void setLecturers(Lecturers lecturers) {
        this.lecturers = lecturers;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public LectureCanTeach(Lecturers lecturers, Courses courses) {
        this.lecturers = lecturers;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "LectureCanTeach{" +
                "lecturers=" + lecturers +
                ", courses=" + courses +
                '}';
    }
}
