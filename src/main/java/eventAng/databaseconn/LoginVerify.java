package eventAng.databaseconn;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class LoginVerify {

	public String loginVerification(String email_id,String password){  
		
		String message = null;
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=(Connection) DriverManager.getConnection(  
		"jdbc:mysql://localhost/db_eventangels","root","India123!");   
		Statement stmt=con.createStatement();  
		
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
		con.close();  
		}catch(Exception e){ System.out.println(e);}
		return message;  
		}  
	}

