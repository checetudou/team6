package sg.edu.iss.team6.controller;

import java.io.Serializable;

import java.util.ArrayList;

import sg.edu.iss.team6.model.Students;
import sg.edu.iss.team6.model.Lecturers;


public class UserSession implements Serializable {
	

	private static final long serialVersionUID = 1L;

	private Lecturers lecturerId = null;
	private Lecturers adminId = null;
	private Students studentId = null;
	private ArrayList<Lecturers> lecturerList = null;
	private ArrayList<Students> studentList = null;
	
	public UserSession() {
		super();
	}
 
	public UserSession(Lecturers lecturer, Students student, ArrayList<Lecturers> lecturerList, ArrayList<Students> studentList) {
		super();


		this.lecturerId = lecturer;
		this.studentId = student;
		this.lecturerList = lecturerList;
		this.studentList = studentList;
	}
	
	public Lecturers getLecturerId() {
		return lecturerId;
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
