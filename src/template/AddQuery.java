package template;

import java.sql.ResultSet;
import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class AddQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", MemberQuery.INSERT.toString());
	}
	@Override
	void startPlay() {
		try {
			/*pstmtInit()으로 대체
			 * pstmt=DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));*/
			MemberBean bean = (MemberBean) map.get("member");
			pstmt.setString(1, bean.getUserid());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getSsn());
			pstmt.setString(4, bean.getPassword());
			pstmt.setString(5, bean.getTeamId());
			pstmt.setString(6, bean.getRoll());
			pstmt.setString(7, bean.getGender());
			pstmt.setString(8, bean.getAge());
			
		} catch (Exception e) {e.printStackTrace();}
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs  = pstmt.executeQuery();
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
				list.add(mem);  //super.list.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
