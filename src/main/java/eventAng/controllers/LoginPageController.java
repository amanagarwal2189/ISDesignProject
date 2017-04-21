package eventAng.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginPageController {

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String directToLogin() {
        return "login";
    }
	
	@RequestMapping(value = "/directToDashboard", method = RequestMethod.GET)
    public String directToDashboard() {
        return "dashboard";
    }
	
	
	@RequestMapping(value = "/sponsorboard", method = RequestMethod.GET)
    public String directToSponsorDashboard() {
        return "sponsorboard";
    }
}
