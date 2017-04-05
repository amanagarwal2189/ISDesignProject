package eventAng;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConnection {

	private static String driverName = "com.mysql.jdbc.Driver";   
    
    private static Connection con;
    
    private DBConnection(){
    	
    }
    
	public synchronized static Connection getConnection() {
		 

			if (con == null) {

				try {
					Class.forName(driverName);
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				}

				try {

					con = (Connection) DriverManager
							.getConnection("jdbc:mysql://localhost:3306/db_eventangels?" + "user=root&password=India123!");

				} catch (SQLException ex) {

					System.out.println("Failed to create the database connection.");
				}
			}
		return con;
	}
}
