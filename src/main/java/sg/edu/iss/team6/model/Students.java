package sg.edu.iss.team6.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Table(name = "students")
@NoArgsConstructor
@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    private String firstName;
    private String lastName;
    private Date enrollmentDate;
    private String email;
    private byte[] photo;
    private String password;

    @OneToMany(mappedBy = "students")
    private Collection<StudentAttendCourse> studentAttendCourses = new ArrayList<StudentAttendCourse>();

    public Students(int studentId, String firstName, String lastName, Date enrollmentDate, String email, byte[] photo, String password) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrollmentDate = enrollmentDate;
        this.email = email;
        this.photo = photo;
        this.password = password;
    }

    public Students(String firstName, String lastName, Date enrollmentDate, String email, byte[] photo, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrollmentDate = enrollmentDate;
        this.email = email;
        this.photo = photo;
        this.password = password;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                ", email='" + email + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", password='" + password + '\'' +
                '}';
    }
}
