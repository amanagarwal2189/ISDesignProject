package eventAng.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eventAng.model.HostDao;
import eventAng.model.SponsorDao;
import eventAng.services.HostRegister;
import eventAng.services.SponsorRegister;

@Controller
public class UserRegisterController {

	 @Autowired
	 private SponsorDao sponsorDao;
	 
	 @Autowired
	 private HostDao hostDao;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request, Model model){
		String userType=request.getParameter("userType");
		String name = request.getParameter("uname");
		String email_id=request.getParameter("emailId");
        String newPassword=request.getParameter("newPassword");
        String confPassword=request.getParameter("confPassword");
		HostRegister hostRegister = new HostRegister();
		SponsorRegister sponsorRegister = new SponsorRegister();
		if(("organizer").equals(userType)){
		hostRegister.hostRegistration(hostDao, name, email_id, newPassword, confPassword);
		return "dashboard";
		}
		else{
		sponsorRegister.sponsorRegistration(sponsorDao,name, email_id, newPassword, confPassword);	
		return "sponsorboard";	
		}
	}
}
