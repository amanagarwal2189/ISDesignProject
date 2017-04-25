package eventAng.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("session")
public class CreateEventPageController {
	
	@Autowired
	private HttpSession httpSession;

	@RequestMapping(value = "/createEvent", method = RequestMethod.GET)
    public String directToLogin(HttpServletRequest request) {
		HttpSession session=request.getSession();
		if(session==null){
			return "login";
		}
		else{
			String userId= (String) request.getSession().getAttribute("user_id");
			String userEmailId= (String) request.getSession().getAttribute("user_emailId");
        return "createEvent";
		}
    }
	
	
	
}