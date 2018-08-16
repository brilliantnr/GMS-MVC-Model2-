package template;

import java.sql.ResultSet;
import domain.*;
import enums.*;

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
			while(rs.next()) {
				o= new MemberBean();
				((MemberBean) o).setAge(rs.getString("AGE"));
				((MemberBean) o).setName(rs.getString("NAME"));
				((MemberBean) o).setPassword(rs.getString("PASSWORD"));
				((MemberBean) o).setRoll(rs.getString("ROLL"));
				((MemberBean) o).setSsn(rs.getString("SSN"));
				((MemberBean) o).setUserid(rs.getString("USERID"));
				((MemberBean) o).setTeamId(rs.getString("TEAMID"));
				((MemberBean) o).setGender(rs.getString("GENDER"));
				((MemberBean) o).setSubject(rs.getString("SUBJECT"));
				list.add(((MemberBean) o));  //리턴타입 List
			}
		} catch (Exception e) {e.printStackTrace();}
		
	}

}
