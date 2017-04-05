package eventAng.databaseconn;

import java.sql.DriverManager;
import java.util.Calendar;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class HostRegister {

	
	public String hostRegistration(String name,String email_id,String newPassword, String confPassword){  
		String message=null;
		try
	    {
	      // create a mysql database connection
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=(Connection) DriverManager.getConnection(  
			"jdbc:mysql://localhost/db_eventangels","root","India123!"); 
	      // create a sql date object so we can use it in our INSERT statement
	      Calendar calendar = Calendar.getInstance();
	      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

	      // the mysql insert statement
	      String query = " insert into tb_host_dtls (name, email_id, is_active, regd_on, password)"
	        + " values (?, ?, ?, ?, ?)";

	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
	      preparedStmt.setString (1, name);
	      preparedStmt.setString (2, email_id);
	      preparedStmt.setString (3, "Y");
	      preparedStmt.setDate   (4, startDate);
	      preparedStmt.setString (5, confPassword);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      message="successInsert";
	      con.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
		return message;

		}  
}
