package eventAng.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eventAng.domain.Host;
import eventAng.domain.Sponsor;
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
	 @Autowired
	private HttpSession httpSession;
	
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
		Host host = hostDao.findByEmailId(email_id);
		httpSession.setAttribute("user_type", userType);
		httpSession.setAttribute("user_emailId", email_id);
		httpSession.setAttribute("user_id", host.getId().toString());
		httpSession.setAttribute("user_name", name);
		return "dashboard";
		}
		else{
			Sponsor sponsor = sponsorDao.findByEmailId(email_id);
			httpSession.setAttribute("user_type", userType);
			httpSession.setAttribute("user_emailId", email_id);
			httpSession.setAttribute("user_id", sponsor.getId().toString());
			httpSession.setAttribute("user_name", name);
			sponsorRegister.sponsorRegistration(sponsorDao,name, email_id, newPassword, confPassword);	
		return "sponsorboard";	
		}
	}
}
