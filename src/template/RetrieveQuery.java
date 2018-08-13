package template;

import java.sql.ResultSet;
import domain.MemberBean;
import enums.MemberQuery;

public class RetrieveQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("--RetrieveQuery 진입 ");
		map.put("sql", MemberQuery.RETRIEVE.toString());
		/*" SELECT "
		+ ColumnFinder.find(Domain.MEMBER)
		+ " FROM MEMBER " 
		+ " WHERE USERID LIKE ? "*/
	}
	
	@Override
	void startPlay() {
		try {
			/*pstmt=DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));*/
			
			String id = (String) map.get("id");
			System.out.println("RetrieveQuery id : "+id);
			pstmt.setString(1, id);
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
			}
			o=mem;
		} catch (Exception e) {e.printStackTrace();}
	}
}
