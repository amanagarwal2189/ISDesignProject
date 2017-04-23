package eventAng.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import eventAng.domain.Host;
import eventAng.domain.Sponsor;
import eventAng.model.HostDao;
import eventAng.model.SponsorDao;

@Controller
@Scope("session")
public class LoginController {

	@Autowired
	private HttpSession httpSession;

	@Autowired
	HostDao hostDao;

	@Autowired
	SponsorDao sponsorDao;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public void login(@RequestParam String userType, @RequestParam String emailId, @RequestParam String password, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		// int countUser=0;
		// User users = new User();
		String emptyString = "";
		boolean lFlag = false;
		String user_name = emptyString;
		String user_id = emptyString;
		//userType = request.getParameter("userType");
		if (userType.equals("organizer")) {
			Host host = hostDao.findByEmailId(emailId);
			if (host!=null && host.isIs_active()) {
				lFlag = validateUser(password, host.getPassword());
				user_id = String.valueOf(host.getId());
				user_name = host.getName();
			}
		} else {
			Sponsor sponsor = sponsorDao.findByEmailId(emailId);
			if (sponsor!=null && sponsor.getIs_active()) {
				lFlag = validateUser(password, sponsor.getPassword());
				user_id = String.valueOf(sponsor.getId());
				user_name = sponsor.getName();
			}
		}
		// System.out.println(emailId);
		// users = fetchOrganizerDetails(emailId);
		// boolean lFlag =validateUsers(password, users.getPassword());
		System.out.print("Password is " + password);

		if (lFlag) {
			// httpSession.setAttribute("userid", users);
			httpSession.setAttribute("user_type", userType);
			httpSession.setAttribute("user_emailId", emailId);
			httpSession.setAttribute("user_id", user_id);
			httpSession.setAttribute("user_name", user_name);
			response.setContentType("text/html;charset=UTF-8");
			if (userType.equals("organizer")) {
			response.getWriter().write("orgTrue");
			
			}
			else if(userType.equals("sponsor")){
				response.getWriter().write("sponsorTrue");	
			}
		} else {
			// request.setAttribute("error","Invalid user");
			// System.out.println("Invalid");
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("False");
		}
	}

	public Boolean validateUser(String lTypedPassword, String lStoredPassword) {

		boolean lFlag = false;

		if (lTypedPassword.equals(lStoredPassword)) {
			lFlag = true;
		} else {
			lFlag = false;
		}
		return lFlag;
	}

	// @RequestMapping(value = "/login", method = RequestMethod.POST)
	// public String login(HttpServletRequest request, Model model) {
	// String email_id=request.getParameter("email_id");
	// String password=request.getParameter("password");
	// //LoginVerify loginVerify = new LoginVerify();
	// //String message=loginVerify.loginVerification(email_id, password);
	// //System.out.println("Name is"+email_id+" "+ "password:"+password);
	// Users users = new Users();
	// users = fetchOrganizerDetails(email_id);
	// boolean lFlag =validateUsers(password, users.getPassword());
	//
	// if(lFlag){
	// httpSession.setAttribute("users", users);
	//
	//
	// return "dashboard";
	// }
	// else{
	// request.setAttribute("error","Invalid user");
	// System.out.println("Invalid");
	// return "login";
	//
	// }
	// }

	/*
	 * public User fetchOrganizerDetails(String pEmail){
	 * 
	 * PreparedStatement lPstmnt = null; ResultSet lRst = null; User users = new
	 * User();
	 * 
	 * try{ StringBuilder lBuilder = new
	 * StringBuilder("select * from tb_host_dtls where email_id=? and is_active='Y'"
	 * );
	 * 
	 * Connection con=DBConnection.getConnection(); lPstmnt =
	 * (PreparedStatement) con.prepareStatement(lBuilder.toString());
	 * lPstmnt.setString(1, pEmail); lRst=lPstmnt.executeQuery();
	 * System.out.println(pEmail); while(lRst.next()){
	 * users.setId(lRst.getInt(1)); users.setName(lRst.getString(2));
	 * users.setEmail_id(lRst.getString(3)); users.setPhone(lRst.getString(4));
	 * users.setAddress_line_1(lRst.getString(5));
	 * users.setAddress_line_2(lRst.getString(6));
	 * users.setCity(lRst.getString(7)); users.setState(lRst.getString(8));
	 * users.setZip(lRst.getInt(9)); users.setIs_active(lRst.getString(10));
	 * users.setRegd_on(lRst.getDate(11));
	 * users.setPassword(lRst.getString(12)); }
	 * 
	 * }catch(Exception e){ System.out.println(e); } return users; } public
	 * Boolean validateUsers(String lTypedPassword, String lStoredPassword ){
	 * 
	 * boolean lFlag=false;
	 * 
	 * if(lTypedPassword.equals(lStoredPassword)){ lFlag=true; }else{
	 * lFlag=false; } return lFlag; }
	 */
}
