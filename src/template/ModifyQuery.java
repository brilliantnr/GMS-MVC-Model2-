package template;

import enums.MemberQuery;
import factory.DatabaseFactory;

public class ModifyQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("--ModifyQuery 진입 : "+String.format(MemberQuery.UPDATE.toString(),map.get("column").toString()));
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
			/*pstmt = DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));*/
			pstmt.setString(1, map.get("column").toString());
			pstmt.setString(2, map.get("id").toString());
			
		} catch (Exception e) {e.printStackTrace();}
		
	}

	@Override
	void endPlay() {
		try {
			pstmt.executeUpdate();
		} catch (Exception e) {e.printStackTrace();}
	}

}
