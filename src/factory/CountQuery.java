package factory;

import java.util.HashMap;

public class CountQuery implements Query{
	HashMap<String, Object> map;
	
	public CountQuery(HashMap<String, Object> map) {
		this.map = map;
	}
	
	@Override
	public String getQuery() {
		return "  SELECT COUNT(*) AS count FROM " + map.get("table") + " ";
	}

}
