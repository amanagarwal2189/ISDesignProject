package eventAng.controllers;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import eventAng.DBConnection;
import eventAng.domain.Users;

@Controller
public class LoginController {

	@Autowired 
	 private HttpSession httpSession;
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model) {
        String email_id=request.getParameter("email_id");
        String password=request.getParameter("password");
        //LoginVerify loginVerify = new LoginVerify();
        //String message=loginVerify.loginVerification(email_id, password);
        //System.out.println("Name is"+email_id+" "+ "password:"+password);
		Users users = new Users();
		users = fetchOrganizerDetails(email_id);
		boolean lFlag =validateUsers(password, users.getPassword());
        
		if(lFlag){
		httpSession.setAttribute("users", users);
		
		
        return "dashboard";
		}
		else{
			request.setAttribute("error","Invalid user");
			System.out.println("Invalid");
			return "dashboard";
			
		}
    }
	
	public Users fetchOrganizerDetails(String pEmail){
		
		PreparedStatement lPstmnt = null;
		ResultSet lRst			  = null;
		Users users 				  = new Users();
		
		try{
			StringBuilder lBuilder = new StringBuilder("select * from tb_host_dtls where email_id=? and is_active='Y'");
									 
			Connection con=DBConnection.getConnection();
			lPstmnt = (PreparedStatement) con.prepareStatement(lBuilder.toString());
			lPstmnt.setString(1, pEmail);
			lRst=lPstmnt.executeQuery();
			
			while(lRst.next()){
				users.setId(lRst.getInt(1));
				users.setName(lRst.getString(2));
				users.setEmail_id(lRst.getString(3));
				users.setPhone(lRst.getString(4));
				users.setAddress_line_1(lRst.getString(5));
				users.setAddress_line_2(lRst.getString(6));
				users.setCity(lRst.getString(7));
				users.setState(lRst.getString(8));
				users.setZip(lRst.getInt(9));
				users.setIs_active(lRst.getString(10));
				users.setRegd_on(lRst.getDate(11));
				users.setPassword(lRst.getString(12));
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		return users;
	}
	public Boolean validateUsers(String lTypedPassword, String lStoredPassword ){
		
		boolean lFlag=false;
		
		if(lTypedPassword.equals(lStoredPassword)){
			lFlag=true;
		}else{
			lFlag=false;
		}
		return lFlag;
	}

}
