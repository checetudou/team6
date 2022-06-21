package sg.edu.iss.team6.controller;

import java.io.Serializable;
import java.util.ArrayList;

import sg.edu.iss.team6.model.Students;
import sg.edu.iss.team6.model.Lecturers;


public class UserSession implements Serializable {
	

	private static final long serialVersionUID = 1L;
	//private User user = null;
	private Lecturers lecturer = null;
	private Students student = null;
	private ArrayList<Lecturers> lecturerList = null;
	private ArrayList<Students> studentList = null;
	
	public UserSession() {
		super();
	}
   //String sessionId,
	public UserSession( /*User user,*/ Lecturers lecturer, Students student, ArrayList<Lecturers> lecturerList, ArrayList<Students> studentList) {
		super();
		//this.sessionId = sessionId;
		//this.user = user;
		this.lecturer = lecturer;
		this.student = student;
		this.lecturerList = lecturerList;
		this.studentList = studentList;
	}

	public Lecturers getLecturer() {
		return lecturer;
	}
	public void setLecturerId(Lecturers lecturer) {
		this.lecturer = lecturer;
	}
	public Students getStudent() {
		return student;
	}
	public void setStudent(Students student) {
		this.student = student;
	}
	public ArrayList<Lecturers> getLecturerList() {
		return lecturerList;
	}
	public void setLecturerList(ArrayList<Lecturers> lecturerList) {
		this.lecturerList = lecturerList;
	}
	public ArrayList<Students> getStudentList() {
		return studentList;
	}
	public void setStudentList(ArrayList<Students> studentList) {
		this.studentList = studentList;
	}

	/*	
 	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public ArrayList<Employee> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(ArrayList<Employee> subordinates) {
		this.subordinates = subordinates;
	}
	*/
	



}
