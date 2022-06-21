package sg.edu.iss.team6.services;

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
	public Students findStudentBystuID(String studentId) {
		return userRepository.findStudentBystuID(studentId);
	}

	@Override
	public Lecturers findLecturerBylecID(String lecturerId) {
		return userRepository.findLecturerBylecID(lecturerId);
	}

	@Override
	@Transactional
	public Students authenticateStudents(String stuid , String pwd) {
		Students s = userRepository.findStudentBystuID(stuid);
		if (s.getPassword().equals(pwd)) return s;
		else return null;
	}

	@Override
	@Transactional
	public Lecturers authenticateLecturers(String lecid, String pwd) {
		Lecturers l = userRepository.findLecturerBylecID(lecid);
		if (l.getPassword().equals(pwd)) return l;
		else return null;
	}

}
