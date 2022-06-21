package sg.edu.iss.team6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.edu.iss.team6.model.Students;
import sg.edu.iss.team6.services.StudentService;

import javax.servlet.http.HttpSession;

@Controller
public class CommonController {
    @RequestMapping(value = "/")
    public String home(HttpSession session, Model model) {
        UserSession userSession= (UserSession) session.getAttribute("usession");
        model.addAttribute("studentId", new Students());
        return "common-login";
    }

//    @RequestMapping(value = "/home")
//    public String logic(Model model) {
//        //model.addAttribute("students", new Students());
//        return "login";
//    }
//
//    @RequestMapping(value = "/home/authenticate")
//    public String authenticate(@ModelAttribute("students") @Validated Students students, BindingResult bindingResult, Model model,
//                               HttpSession session) {
//        UserSession usession = new UserSession();
//        if (bindingResult.hasErrors()) {
//            return "login";
//
//        } else {
//            Students s = StudentService(students.getStudentId(), students.getPassword());
//            usession.setStudent(s);
//            usession.setEmployee(eService.findEmployeeById(usession.getUser().getEmployeeId()));
//            ArrayList<Employee> subordinates = eService.findSubordinates(usession.getUser().getEmployeeId());
//            if (subordinates != null) {
//                usession.setSubordinates(subordinates);
//            }
//            session.setAttribute("usession", usession);
//            return "forward:/staff/history";
//        }
//
//    }
}
