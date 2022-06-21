package sg.edu.iss.team6.service;

import java.util.ArrayList;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team6.model.Lecturers;
import sg.edu.iss.team6.model.Students;
import sg.edu.iss.team6.repo.UserRepo;


@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepo userRepository;
	@Override
	public ArrayList<Students> findStudentBystuID(String studentId) {
		// TODO Auto-generated method stub
		return userRepository.findStudentBystuID(studentId);
	}

	@Override
	public ArrayList<Lecturers> findLecturerBylecID(String lecturerId) {
		// TODO Auto-generated method stub
		return userRepository.findLecturerBylecID(lecturerId);
	}

	@Override
	@Transactional
	public Students authenticateStudents(String stuid , String pwd) {
		// TODO Auto-generated method stub
		ArrayList<Students> s = userRepository.findStudentBystuID(stuid);
		s.equals(pwd);
		return null;
	}

	@Override
	@Transactional
	public Lecturers authenLecturers(String lecid, String pwd) {
		// TODO Auto-generated method stub
		ArrayList<Lecturers> l = userRepository.findLecturerBylecID(lecid);
		l.equals(pwd);
		return null;
	}

}
