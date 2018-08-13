package template;

import domain.MemberBean;
import enums.MemberQuery;

public class AddQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("--AddQuery 진입 : "+MemberQuery.INSERT.toString());
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
				pstmt.executeUpdate();//void리턴타입
			} catch (Exception e) {e.printStackTrace();}
	}
}
