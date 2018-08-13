package template;

import domain.MemberBean;
import enums.MemberQuery;

public class RemoveQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("--RemoveQuery 진입 ");
		map.put("sql", MemberQuery.DELETE.toString());
		/*"  DELETE "
		+ " FROM MEMBER "
		+ " WHERE USERID LIKE ? "
		+ " AND PASSWORD LIKE ? "
		;*/
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
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
