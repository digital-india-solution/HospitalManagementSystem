import java.sql.*;
import javax.swing.*;
public class DbConnection {
	Connection conn=null;
	public static Connection dbConnector()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Gurpreet\\workspace\\HospitalManagementSystem\\LoginDb.sqlite");
			//JOptionPane.showMessageDialog(null, "yo yo");
			return conn;
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}
