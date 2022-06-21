package sg.edu.iss.team6.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.edu.iss.team6.helper.CourseEventEnum;

@Entity
@Table(name = "courseevent")
@Data
@NoArgsConstructor
public class CourseEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "courseeventid")
	private int courseEventId;
	
	@Column(name = "timestamp")
	private Date timeStamp;
	@Column(name = "eventtype", columnDefinition = "ENUM('A', 'B', 'C', 'D', 'Pass', 'Fail')")
	@Enumerated(EnumType.STRING)
	private CourseEventEnum eventType;
	@Column(name = "eventby")
	private String eventBy;
	@Column(name = "comment")
	private String comment;
	// Reverse Relation
	@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "courseid")
	private Courses course;


	public CourseEvent(int courseEventId, Date timeStamp, CourseEventEnum eventType, String eventBy, String comment,
			Courses course) {
		super();
		this.courseEventId = courseEventId;
		this.timeStamp = timeStamp;
		this.eventType = eventType;
		this.eventBy = eventBy;
		this.comment = comment;
		this.course = course;
	}
	
	

}
