package factory;

import java.util.HashMap;

import enums.MemberQuery;

public class QueryFactory {
	public static String createQuery(HashMap<String, Object> map) {
		Query q = null;
		switch (MemberQuery.valueOf(map.get("query").toString())) {
		case COUNT_MEMBER:
			//q = new CountQuery();
			break;
		default:
			break;
		}
		return null;
	}
}
