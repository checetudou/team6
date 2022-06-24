package sg.edu.iss.team6.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.edu.iss.team6.model.User;
import sg.edu.iss.team6.services.UserService;

@Component
public class UserValidator implements Validator{

    @Autowired
    private UserService uService;

    @Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User u = (User) target;
        if(u.getUserId().length() > 7) {
            String testintg = u.getUserId().substring(0,7);
            if (!(u.getUserId().substring(0,7).equals("nusstu/")) || !(u.getUserId().substring(0,7).equals("nusstf/"))) {
                errors.rejectValue("userId", "error.invalidUserId", "Invalid Format");
            }
            if ((u.getUserId().substring(0,7).equals("nusstu/"))) {
                String actualUser = u.getUserId().substring(8);
                if (uService.findStudentBystuID(actualUser)==null) {
                    errors.rejectValue("userId", "error.invalidUserId", "User doesn't exist");
                } else {
                    if (uService.authenticateStudents(actualUser, u.getPassword())==null) {
                        errors.rejectValue("userId", "error.invalidUserId", "Wrong Username Or Password");
                    }
                }
            }
            if ((u.getUserId().substring(0,7).equals("nusstf/"))) {
                String actualUser = u.getUserId().substring(8);
                if (uService.authenticateLecturers(actualUser, u.getPassword())==null) {
                    errors.rejectValue("userId", "error.invalidUserId", "Wrong Username Or Password");
                }
            }
        }
        if (u.getUserId().length() < 8 && u.getUserId().length() > 0)  {
            errors.rejectValue("userId", "error.invalidUserId", "Invalid Format");
        }
	}
}
