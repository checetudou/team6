package sg.edu.iss.team6.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
@NoArgsConstructor
@Table(name = "courses")
@Entity
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String courseId;
    private String courseName;
    private int size;
    private int actualEnroll;
    private String description;

    @OneToMany(mappedBy = "courses")
    private Collection<LectureCanTeach> lectureCanTeaches = new ArrayList<LectureCanTeach>();

    @OneToMany(mappedBy = "courses")
    private Collection<StudentAttendCourse> studentAttendCourses = new ArrayList<StudentAttendCourse>();

    public Courses(String courseName, int size, int actualEnroll, String description) {
        this.courseName = courseName;
        this.size = size;
        this.actualEnroll = actualEnroll;
        this.description = description;
    }

    public Courses(String courseId, String courseName, int size, int actualEnroll, String description) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.size = size;
        this.actualEnroll = actualEnroll;
        this.description = description;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getActualEnroll() {
        return actualEnroll;
    }

    public void setActualEnroll(int actualEnroll) {
        this.actualEnroll = actualEnroll;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", size=" + size +
                ", actualEnroll=" + actualEnroll +
                ", description='" + description + '\'' +
                '}';
    }

	public void setTimeStamp(Date time) {
		// TODO Auto-generated method stub
		
	}
}
