package sg.edu.iss.team6.controller;

import java.io.Serializable;

import java.util.ArrayList;

import sg.edu.iss.team6.model.Students;
import sg.edu.iss.team6.model.Lecturers;


public class UserSession implements Serializable {
	

	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
<<<<<<< HEAD
	//private User user = null;
	private Lecturers lecturer = null;
	private Students student = null;
=======
	private User user = null;
=======
>>>>>>> 387dcd5 (edit logincontroller)
	private Lecturers lecturerId = null;
	private Lecturers adminId = null;
	private Students studentId = null;
>>>>>>> e27201f (testing)
	private ArrayList<Lecturers> lecturerList = null;
	private ArrayList<Students> studentList = null;
	
	public UserSession() {
		super();
	}
 
	public UserSession(Lecturers lecturer, Students student, ArrayList<Lecturers> lecturerList, ArrayList<Students> studentList) {
		super();
<<<<<<< HEAD
		//this.sessionId = sessionId;
<<<<<<< HEAD
		//this.user = user;
		this.lecturer = lecturer;
		this.student = student;
		this.lecturerList = lecturerList;
		this.studentList = studentList;
	}

	public Lecturers getLecturer() {
		return lecturer;
=======
		this.user = user;
=======

>>>>>>> 387dcd5 (edit logincontroller)
		this.lecturerId = lecturer;
		this.studentId = student;
		this.lecturerList = lecturerList;
		this.studentList = studentList;
	}
	
	public Lecturers getLecturerId() {
		return lecturerId;
>>>>>>> e27201f (testing)
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
	public Lecturers getAdminId() {
		return adminId;
	}
	public void setAdminId(Lecturers adminId) {
		this.adminId = adminId;
	}




}
