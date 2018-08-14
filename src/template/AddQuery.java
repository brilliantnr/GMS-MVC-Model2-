package template;

import domain.MemberBean;
import enums.*;

public class AddQuery extends QueryTemplate{

	@Override
	void initialize() {
		switch (map.get("table").toString()) {
		case "MEMBER":
			System.out.println("--AddQuery 진입 : "+MemberQuery.INSERT.toString());
			map.put("sql", MemberQuery.INSERT.toString());
			break;
		case "IMAGE":
			System.out.println("--AddQuery 진입 : "+ImageQuery.INSERT.toString());
			map.put("sql", ImageQuery.INSERT.toString());
			break;
		default:
			break;
		}
		
	}
	@Override
	void startPlay() {
		switch (map.get("table").toString()) {
		case "MEMBER":
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
			break;
		case "IMAGE":
			try {
				System.out.println("AddQuery IMAGE 진입");
				pstmt.setString(1, (String) map.get("imgname"));
				pstmt.setString(2, (String) map.get("ext"));
				pstmt.setString(3, (String) map.get("userid"));
			} catch (Exception e) {e.printStackTrace();}
			break;
		default:
			break;
		}
	}

	@Override
	void endPlay() {
			try {
				pstmt.executeUpdate();//void리턴타입
			} catch (Exception e) {e.printStackTrace();}
	}
}
