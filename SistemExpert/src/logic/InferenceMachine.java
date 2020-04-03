package logic;

import manager.JsonServices;
import manager.Parser;
import java.sql.*;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class InferenceMachine {

	ResultSet resultSet = null;
	Parser dbParser = new Parser();

	public List<JSONObject> getJsonObject() throws SQLException {
		resultSet = dbParser.getResultSet();
		List<JSONObject> resList = JsonServices.getFormattedResult(resultSet);
		return resList;
	}

	public static List<JSONObject> initialList;
	static List<JSONObject> partialList;

	public void initList() throws SQLException, JSONException {
		this.initialList = this.getJsonObject();
	}

	// public static void main(String args[]) throws SQLException, JSONException {
	// InferenceMachine m = new InferenceMachine();
	// m.initList();
	// for (int i = 0;i<m.initialList.size();i++)
	// {
	// System.out.println(m.initialList.get(i));
	// }
	//
	// }

}
