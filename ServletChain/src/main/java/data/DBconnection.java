package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection 
{
	public static Connection dbconnect()
	{
		Connection cn = null;
		try {
			Class.forName("com.jdbc.cj.mysql.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","");
			
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}

}
