package eventAng.services;

import java.util.ArrayList;
import java.util.List;

import eventAng.domain.Event;
import eventAng.model.EventDao;

public class DisplayEvent {

	public List<Event> displayEventForLanding(EventDao eventDao){
		//String message=null;
		List<Event> eventList = new ArrayList<Event>();
		eventList= eventDao.findTop4ByOrderByTitleDesc();
		
		
		/*try{  
			Connection con=DBConnection.getConnection();  
			Statement stmt=con.createStatement();  
			
			ResultSet rs;
			Event event;
	            String sql = "Select * from tb_event_dtls ORDER BY id DESC LIMIT 0,4";
	           
	            rs = stmt.executeQuery(sql);
	            while (rs!=null && rs.next()) {
	            event=new Event();
	               event.setId(rs.getLong(1));
	               event.setHost_id(rs.getInt(2));
	               event.setTitle(rs.getString(3));
	               event.setCity(rs.getString(8));
	               event.setState(rs.getString(9));
	               //message = "FetchSuccess";
	               eventList.add(event);         	
	            } 
			}catch(Exception e){ System.out.println(e);}*/
		return eventList;
	}
	
	public List<Object> displayEventForOrganizer(EventDao eventDao, Long hostId){
		//String message=null;
		List<Object> eventListForOrg = new ArrayList<Object>();
		try{/*  
			Connection con=DBConnection.getConnection(); 
			
			ResultSet rs;
			Event event;
			PreparedStatement lPstmnt = null;
			StringBuilder lBuilder = new StringBuilder("Select * from tb_event_dtls where host_id=?");
	           
	            lPstmnt = (PreparedStatement) con.prepareStatement(lBuilder.toString());
	            lPstmnt.setLong(1, hostId);
	            rs = lPstmnt.executeQuery();
	            while (rs.next()) {
	            event=new Event();
	               event.setId(rs.getLong(1));
	               event.setHost_id(rs.getLong(2));
	               event.setTitle(rs.getString(3));
	               event.setCity(rs.getString(8));
	               event.setState(rs.getString(9));
	               //message = "FetchSuccess";
	               eventListForOrg.add(event);           	
	            } 
			*/}catch(Exception e){ System.out.println(e);}
		return eventListForOrg;
	}
}
