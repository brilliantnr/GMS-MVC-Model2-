package template;

import java.sql.ResultSet;

import domain.MemberBean;
import enums.MemberQuery;

public class LoginQuery extends QueryTemplate {
	
	@Override
	void initialize() {
		System.out.println("--LoginQuery 진입 : "+MemberQuery.LOGIN.toString());
		map.put("sql", MemberQuery.LOGIN.toString());
	}

	@Override
	void startPlay() {
		try {
			MemberBean bean = (MemberBean) map.get("member");
			pstmt.setString(1, bean.getUserid());
			pstmt.setString(2, bean.getPassword());
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
