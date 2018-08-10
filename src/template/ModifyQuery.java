package template;

import java.sql.ResultSet;
import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class ModifyQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("--ModifyQuery 진입 ");
		map.put("sql", 
				String.format(MemberQuery.UPDATE.toString(),
				map.get("column").toString()));  //command 담기
	
	}
	/*query = " UPDATE  "
			+ " MEMBER SET %s = ? "
			+ " WHERE USERID LIKE ? "
			;*/
	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));
			pstmt.setString(1, map.get("column").toString());
			pstmt.setString(2, map.get("id").toString());
			
		} catch (Exception e) {e.printStackTrace();}
		
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
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
				list.add(mem);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
