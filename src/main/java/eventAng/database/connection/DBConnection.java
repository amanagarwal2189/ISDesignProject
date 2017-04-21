package eventAng.database.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConnection {

	private static String driverName = "com.mysql.jdbc.Driver";   
    private static DBConnection dbconn;
    private Connection con;
    
    
    private DBConnection(){
    	try {
    		Class.forName(driverName).newInstance();
			this.con=(Connection) DriverManager
					//.getConnection("jdbc:mysql://localhost:3306/db_eventangels?reconnect=true","root","India123!");
					.getConnection("jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_23ac5692749e275?reconnect=true","b36c61f7d63a44","4a7093b5");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
	public synchronized static Connection getConnection() {
			if (dbconn == null) {
				dbconn = new DBConnection();
			}	
		return dbconn.con;
	}
	
	
}
