package eventAng.databaseconn;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import eventAng.domain.Events;

public class DisplayEvent {

	
	public List<Object> displayEventForLanding(){
		//String message=null;
		List<Object> eventList = new ArrayList<Object>();
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=(Connection) DriverManager.getConnection(  
			"jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/heroku_23ac5692749e275?reconnect=true","b36c61f7d63a44","4a7093b5");   
			Statement stmt=con.createStatement();  
			
			ResultSet rs;
			Events event;
	            String sql = "Select * from tb_event_dtls ORDER BY id DESC LIMIT 0,4";
	           
	            rs = stmt.executeQuery(sql);
	            while (rs.next()) {
	            event=new Events();
	               event.setId(rs.getInt(1));
	               event.setHost_id(rs.getInt(2));
	               event.setTitle(rs.getString(3));
	               event.setCity(rs.getString(8));
	               event.setState(rs.getString(9));
	               //message = "FetchSuccess";
	               eventList.add(event);
	               
	            	
	            } 
			
			//ResultSet rs=stmt.executeQuery("select * from emp");  
			
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		return eventList;
	}
}
