package eventAng.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("session")
public class HomeController {
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    
    @RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
    public String aboutUs() {
        return "aboutus";
    }
    
    @RequestMapping(value = "/backToDashHome", method = RequestMethod.GET)
    public String backToDashBoHome(HttpServletRequest request) {
    	String user_type= (String) request.getSession().getAttribute("user_type");
        if(user_type.equals("organizer")){
    	return "dashboard";
        }
        else
        	return "sponsorBoard";
        
    }
    
    @RequestMapping(value = "/sponsorOutside", method = RequestMethod.GET)
    public String sponsorOutside() {
        return "sponsorBoardOutside";
    }

    
    @RequestMapping(value = "/aboutUsInside", method = RequestMethod.GET)
    public String aboutUsInside() {
        return "aboutus_inside";
    }
    
}