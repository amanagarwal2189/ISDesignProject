package eventAng.databaseconn;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import eventAng.DBConnection;
import eventAng.domain.Events;

public class DisplayEvent {

	
	public List<Object> displayEventForLanding(){
		//String message=null;
		List<Object> eventList = new ArrayList<Object>();
		try{  
			Connection con=DBConnection.getConnection();  
			Statement stmt=con.createStatement();  
			
			ResultSet rs;
			Events event;
	            String sql = "Select * from tb_event_dtls ORDER BY id DESC LIMIT 0,4";
	           
	            rs = stmt.executeQuery(sql);
	            while (rs!=null && rs.next()) {
	            event=new Events();
	               event.setId(rs.getInt(1));
	               event.setHost_id(rs.getInt(2));
	               event.setTitle(rs.getString(3));
	               event.setCity(rs.getString(8));
	               event.setState(rs.getString(9));
	               //message = "FetchSuccess";
	               eventList.add(event);         	
	            } 
			}catch(Exception e){ System.out.println(e);}
		return eventList;
	}
	
	public List<Object> displayEventForOrganizer(int hostId){
		//String message=null;
		List<Object> eventListForOrg = new ArrayList<Object>();
		try{  
			Connection con=DBConnection.getConnection(); 
			
			ResultSet rs;
			Events event;
			PreparedStatement lPstmnt = null;
			StringBuilder lBuilder = new StringBuilder("Select * from tb_event_dtls where host_id=?");
	           
	            lPstmnt = (PreparedStatement) con.prepareStatement(lBuilder.toString());
	            lPstmnt.setInt(1, hostId);
	            rs = lPstmnt.executeQuery();
	            while (rs.next()) {
	            event=new Events();
	               event.setId(rs.getInt(1));
	               event.setHost_id(rs.getInt(2));
	               event.setTitle(rs.getString(3));
	               event.setCity(rs.getString(8));
	               event.setState(rs.getString(9));
	               //message = "FetchSuccess";
	               eventListForOrg.add(event);           	
	            } 
			}catch(Exception e){ System.out.println(e);}
		return eventListForOrg;
	}
}
