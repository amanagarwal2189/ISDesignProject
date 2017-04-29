package eventAng.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	 
	 @ResponseBody
	 @RequestMapping(value = "/userCheck", method = RequestMethod.GET)
		public void userCheck(HttpServletRequest request, HttpServletResponse response,@RequestParam String userType, @RequestParam String emailId) throws IOException{
	 
		 //String userType=request.getParameter("userType");
		 //String email_id=request.getParameter("newemailId");
		 System.out.println(emailId);
		 String message = null;
		 if (("organizer").equals(userType)) {
			 Host host = hostDao.findByEmailId(emailId);
			 if(host!=null){
				 message = "exist";
				 response.getWriter().write(message);
			 }
			 else{
				 message = "notExist";
				 response.getWriter().write(message);
			 }
		 }
		 else{
			 Sponsor sponsor = sponsorDao.findByEmailId(emailId);
			 if(sponsor!=null){
				 message = "exist";
				 
				 response.getWriter().write(message);
			 }
			 else{
				 message = "notExist";
				 response.getWriter().write(message);
			 }
		 }
		 
		 System.out.println(message);
		 
	 }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request, Model model){
		String userType=request.getParameter("userType");
		String name = request.getParameter("uname");
		String email_id=request.getParameter("newemailId");
        String newPassword=request.getParameter("newPassword");
        String confPassword=request.getParameter("confPassword");
		if (("organizer").equals(userType)) {
			
				HostRegister hostRegister = new HostRegister();
			
				Host host = hostRegister.hostRegistration(hostDao, name, email_id, newPassword, confPassword);
				httpSession.setAttribute("user_type", userType);
				httpSession.setAttribute("user_emailId", email_id);
				httpSession.setAttribute("user_id", host.getId().toString());
				httpSession.setAttribute("user_name", name);
				return "dashboard";
			
		}
		else{
			
				SponsorRegister sponsorRegister = new SponsorRegister();
				Sponsor sponsor=sponsorRegister.sponsorRegistration(sponsorDao, name, email_id, newPassword, confPassword);
				httpSession.setAttribute("user_type", userType);
				httpSession.setAttribute("user_emailId", email_id);
				httpSession.setAttribute("user_id", sponsor.getId().toString());
				httpSession.setAttribute("user_name", name);
				
				return "sponsorboard";	
			
		}
	}
}
