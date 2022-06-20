package sg.edu.iss.team6.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Data
@Table(name = "lecturers")
@NoArgsConstructor
@Entity
public class Lecturers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String lecturerId;
    private String firstName;
    private String lastName;
    private String email;
    private byte[] photo;
    private String password;
    private boolean adminOrNot;

    @OneToMany(mappedBy = "lecturers")
    private Collection<LectureCanTeach> lectureCanTeaches = new ArrayList<LectureCanTeach>();

    @OneToMany(mappedBy = "adminOrNot")
    private Collection<Lecturers> lecturers = new ArrayList<Lecturers>();

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinTable(name = "lecturerTolecturer", joinColumns = { @JoinColumn(name = "lecturerId") }, inverseJoinColumns = { @JoinColumn(name = "adminId") } )
    private Lecturers admin;

    public Lecturers(String lecturerId, String firstName, String lastName, String email, byte[] photo, String password, boolean adminOrNot) {
        this.lecturerId = lecturerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.photo = photo;
        this.password = password;
        this.adminOrNot = adminOrNot;
    }

    public Lecturers(String firstName, String lastName, String email, byte[] photo, String password, boolean adminOrNot) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.photo = photo;
        this.password = password;
        this.adminOrNot = adminOrNot;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
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

    public boolean isAdminOrNot() {
        return adminOrNot;
    }

    public void setAdminOrNot(boolean adminOrNot) {
        this.adminOrNot = adminOrNot;
    }

    @Override
    public String toString() {
        return "Lecturers{" +
                "lecturerId='" + lecturerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", password='" + password + '\'' +
                ", adminOrNot=" + adminOrNot +
                '}';
    }
}
