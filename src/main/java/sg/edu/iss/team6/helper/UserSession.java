package sg.edu.iss.team6.helper;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.model.Students;

@Data
@NoArgsConstructor
public class UserSession {
    private Students student=null;
    private Lecturers lecturer=null;
    private boolean adminOrNot=false;
    
    public UserSession(Students student) {
        this.student = student;
    }

    public UserSession(Lecturers lecturer, boolean adminOrNot) {
        this.lecturer = lecturer;
        this.adminOrNot = adminOrNot;
    }


}
