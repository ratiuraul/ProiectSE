package logic;

import manager.JsonServices;
import manager.Parser;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import logic.InferenceMachine.*;

import org.json.JSONException;
import org.json.JSONObject;

public class Triage {

	static Boolean KeepAsking = true;

	public static List<JSONObject> sortList(List<JSONObject> pl, String objectKey, String objectValue)
			throws SQLException, JSONException {

		// InferenceMachine m = new InferenceMachine();
		// m.initList();
		//
		List<JSONObject> return_list =  new ArrayList<>() ;

		for (JSONObject obj : pl) {
			System.out.println(obj.get(objectKey));
			System.out.println(objectValue);
			if (obj.get(objectKey).equals(objectValue)) {
				return_list.add(obj);
			}
		}
		return return_list;
	}

	public static List<JSONObject> getFinalResults(List<JSONObject> result, String questionType, String answer)
			throws SQLException, JSONException {

		InferenceMachine m = new InferenceMachine();
		m.initList();
		result = m.initialList;

		while (KeepAsking) {
			result = sortList(result, questionType, answer);
			KeepAsking = false;
		}
		return result;
	}

	public static void main(String args[]) throws SQLException, JSONException {
		InferenceMachine m = new InferenceMachine();
		m.initList();
		List<JSONObject> l ;
		l = sortList(m.initialList, "BRAND", "DELL");
		
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
	
	}

}
