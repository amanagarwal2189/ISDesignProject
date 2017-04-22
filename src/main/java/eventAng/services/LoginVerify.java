package eventAng.services;

import java.sql.ResultSet;
import java.sql.Statement;

import eventAng.database.connection.DBConnection;

public class LoginVerify {

	public String loginVerification(String email_id,String password){/*  
		
		String message = null;
		
		try{  
		Class.forName("com.mysql.jdbc.Driver");   
		Statement stmt=DBConnection.getConnection().createStatement();
		ResultSet rs;
		if (email_id != null && password != null) {
            String sql = "Select * from tb_host_dtls Where email_id='" + email_id + "' and password='" + password + "'";
            rs = stmt.executeQuery(sql);
            
            if (rs.next()) {
               message = "loginSuccess";
               
            	
            } else {
            	message = "loginFailed";
            }
		
		//ResultSet rs=stmt.executeQuery("select * from emp");  
		}
		else{
			message = "notAUser";
		}
		stmt.close();
		}catch(Exception e){ System.out.println(e);}
		return message;  
		*/
		return "";
	}
		
	}

