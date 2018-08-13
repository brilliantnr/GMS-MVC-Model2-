package template;

import java.sql.ResultSet;
import domain.MemberBean;
import enums.MemberQuery;

public class SearchQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("--SearchQuery 진입 ");
		map.put("sql", 
				(!map.containsKey("column")) ?
						MemberQuery.LIST.toString() : 
							String.format(MemberQuery.SEARCH.toString(),
									map.get("column").toString())
				);
	}
	/*" SELECT T.* FROM (SELECT ROWNUM SEQ, " + 
	" M.* " + 
	" FROM MEMBER M " + 
	" WHERE %s LIKE ? "+ //"column"
	" ORDER BY SEQ DESC) T " + 
	" WHERE T.SEQ BETWEEN ? AND ? ";*/
	@Override
	void startPlay() {
		try {
			
			/*QueryTemplate에서 pstmtInit();메소드로 만듦
			 * pstmt = DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));*/
			int j=0;
			if(map.containsKey("column")) {
				j++;
				pstmt.setString(j,"%"+map.get("value").toString()+"%");
			}
			j++;
			pstmt.setString(j, map.get("beginRow").toString());
			j++;
			pstmt.setString(j, map.get("endRow").toString());
			
		} catch (Exception e) {e.printStackTrace();}
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs  = pstmt.executeQuery();//리턴타입 있을 경우 resultSet 사용(DB에서 꺼내오는 수도꼭지)
			MemberBean mem = null;
			while(rs.next()) {
				mem= new MemberBean();
				mem.setAge(rs.getString("AGE"));
				mem.setName(rs.getString("NAME"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setSsn(rs.getString("SSN"));
				mem.setUserid(rs.getString("USERID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setGender(rs.getString("GENDER"));
				mem.setSubject(rs.getString("SUBJECT"));
				list.add(mem);  //리턴타입 List
			}
		} catch (Exception e) {e.printStackTrace();}
		
	}

}
