package eventAng.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import eventAng.databaseconn.HostRegister;

@Controller
public class UserRegisterController {

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request, Model model){
		/*String name = request.getParameter("uname");
		String email_id=request.getParameter("emailId");
        String newPassword=request.getParameter("newPassword");
        String confPassword=request.getParameter("confPassword");
		HostRegister hostRegister = new HostRegister();
		String regHost = hostRegister.hostRegistration(name, email_id, newPassword, confPassword);
		*/
		return "dashboard";
		
		
	}
}
