package template;

import java.sql.ResultSet;
import domain.MemberBean;
import enums.Domain;
import factory.*;

public class PstmtQuery extends QueryTemplate {
	@Override
	void initialize() {
		System.out.println("--10.PstmtQuery initialize");
			
		//factory사용
		//map.put("sql", QueryFactory.createQuery(map));
		if(map.get("value")==null) {
			map.put("sql",String.format(
					" SELECT "
					+ ColumnFinder.find(Domain.MEMBER)
					+" FROM %s "
					+ " WHERE %s ", 
					map.get("table"),
					map.get("column")));
			System.out.println("--value null");
			System.out.println("--쿼리 : "+map.get("sql"));
		}else {
			//sql완성해서 map에 담기
			map.put("sql", String.format(
					" SELECT "
					+ ColumnFinder.find(Domain.MEMBER)
					+" FROM %s "
					+ " WHERE %s "
					+ " LIKE ? ",  //<-PreparedStatement
					map.get("table"),
					map.get("column")));
			//column 찾는 동적메소드 만든다 
		}
	}

	@Override
	void startPlay() {
		System.out.println("----2단계");
		if(map.get("value")==null) {
			try {
				pstmt = DatabaseFactory.createDatabase2(map)
						.getConnection().prepareStatement((String)map.get("sql"));
			} catch (Exception e) {e.printStackTrace();}
			
		}else {
			try {
				pstmt = DatabaseFactory.createDatabase2(map)
						.getConnection().prepareStatement((String)map.get("sql"));
				pstmt.setString(1, "%"+map.get("value").toString()+"%");
			} catch (Exception e) {e.printStackTrace();}
		}
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
