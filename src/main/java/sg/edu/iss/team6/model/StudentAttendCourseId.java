package sg.edu.iss.team6.model;

import java.io.Serializable;

public class StudentAttendCourseId implements Serializable {

    private Students students;
    private Courses courses;
    
    //Apparently this class is required since StudentAttendCourse contains non-key fields. 
    //It is linked to StudentAttendCourse via the @IdClass  class-level annotation.
}
