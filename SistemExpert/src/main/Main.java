package main;

import manager.JsonServices;
import manager.DbConnector;
import manager.Parser;
import java.sql.*;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class Main {

	ResultSet resultSet = null;
	Parser dbParser = new Parser();

	public List<JSONObject> getJsonObject() throws SQLException {
		resultSet = dbParser.getResultSet();
		List<JSONObject> resList = JsonServices.getFormattedResult(resultSet);
		return resList;
	}
}
//	public static void main(String args[]) throws SQLException, JSONException {
//		Main m = new Main();
//		List<JSONObject> jObjList = m.getJsonObject();
//		JSONObject obj = new JSONObject();
//
////		for (int i = 0;i<jObj.size();i++)
////		{
////			System.out.println(jObj.get(i));
////		} 
//		obj = jObjList.get(2);
//		
//		System.out.println(obj.getString("SISTEM_DE_OPERARE"));
//	}
//
//}
