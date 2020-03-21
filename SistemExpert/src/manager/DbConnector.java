package manager;

import java.sql.*;

public class DbConnector {
	
	Connection myConn = null;
	
	Statement myStatement = null;

	ResultSet myRs = null;
	
	public DbConnector() throws SQLException {
		

		this.myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ioana","root","a1b2c3d4!");
		
		this.myStatement = myConn.createStatement();
		
		this.myRs = myStatement.executeQuery("select * from chestionar");
		
	}



}
//			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ioana","root","a1b2c3d4");

