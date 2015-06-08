import java.sql.*;

import javax.swing.JOptionPane;
public class ConnectionMain {

	Connection conn = null;
	public static Connection dbConnector()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl = "jdbc:mysql://localhost:3306/jdbc";
			String connectionUser = "root";
			String connectionPassword = "root"; 
			Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			
			return conn;
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
