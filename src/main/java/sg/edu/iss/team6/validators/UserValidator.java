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
        if (!(u.getUserId().substring(0,8).equals("nusstu/")) || !(u.getUserId().substring(0,8).equals("nusstf/"))) {
            errors.reject("userId", "Invalid Format");
        }
        if ((u.getUserId().substring(0,8).equals("nusstu/"))) {
            String actualUser = u.getUserId().substring(8);
            if (uService.authenticateStudents(actualUser, u.getPassword())==null) {
                errors.reject("userId", "Wrong Password");
            }
        }
        if ((u.getUserId().substring(0,8).equals("nusstf/"))) {
            String actualUser = u.getUserId().substring(8);
            if (uService.authenticateLecturers(actualUser, u.getPassword())==null) {
                errors.reject("userId", "Wrong Password");
            }
        }
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "error.user.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.user.password.empty");
	}
}
