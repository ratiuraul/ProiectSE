package manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import manager.DbConnector;

public class Parser {
	

	public ResultSet getResultSet() throws SQLException {

		DbConnector myConn = new DbConnector();
		myConn.myRs = myConn.myStatement.executeQuery("select * from chestionar");
		return myConn.myRs;
	 }

}
