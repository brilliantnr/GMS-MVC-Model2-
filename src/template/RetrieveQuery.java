package template;

import java.sql.ResultSet;
import domain.*;
import enums.*;

public class RetrieveQuery extends QueryTemplate {

	@Override
	void initialize() {
		switch (map.get("table").toString()) {
		case "MEMBER":
			System.out.println("--RetrieveQuery 1.initialize -MEMBER진입 ");
			map.put("sql", MemberQuery.RETRIEVE.toString());
			System.out.println("--RetrieveQuery 1.initialize -MEMBER 끝 ");
			break;
		case "IMAGE":
			System.out.println("--RetrieveQuery -IMAGE진입1 ");
			map.put("sql",ImageQuery.RETRIEVE.toString());
			break;
		default:
			break;
		}

	}

	@Override
	void startPlay() {
		System.out.println("--RetrieveQuery 2.startPlay 진입 ");
		switch (map.get("table").toString()) {
		
		case "MEMBER":
			try {
				System.out.println("--RetrieveQuery 2.startPlay switch(MEMBER) ");
				String id = (String) map.get("id");
				System.out.println(" id : " + id);
				pstmt.setString(1, id);
				System.out.println("--RetrieveQuery 2.startPlay (MEMBER) 끝 ");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "IMAGE":
			try {
				System.out.println("--RetrieveQuery 2.startPlay (IMAGE) 진입 ");
				pstmt.setString(1, (String) map.get("id"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	@Override
	void endPlay() {
		System.out.println("--RetrieveQuery 3.endPlay 진입 ");
		switch (map.get("table").toString()) {
		case "MEMBER":
			try {
				System.out.println("--RetrieveQuery 3.endPlay switch(MEMBER) 진입 ");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println("--RetrieveQuery 3.endPlay while 진입");
					o = new MemberBean();  //★★★★★
					((MemberBean) o).setAge(rs.getString("AGE"));
					((MemberBean) o).setName(rs.getString("NAME"));
					((MemberBean) o).setPassword(rs.getString("PASSWORD"));
					((MemberBean) o).setRoll(rs.getString("ROLL"));
					((MemberBean) o).setSsn(rs.getString("SSN"));
					((MemberBean) o).setUserid(rs.getString("USERID"));
					((MemberBean) o).setTeamId(rs.getString("TEAMID"));
					((MemberBean) o).setGender(rs.getString("GENDER"));
					((MemberBean) o).setSubject(rs.getString("SUBJECT"));
					System.out.println("RetrieveQuery endPlay 결과물 : "+o);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "IMAGE":
			try {
				System.out.println("--RetrieveQuery 3.endPlay switch(IMAGE) 진입 ");
				ResultSet rs = pstmt.executeQuery();
				System.out.println("while전 =======================");
				while(rs.next()) {
					o=new ImageBean();
					System.out.println("rs.getString(\"USERID\")"+rs.getString("USERID"));
					System.out.println("rs.getString(\"EXTENSION\")"+rs.getString("EXTENSION"));
					System.out.println("rs.getString(\"IMG_NAME\")"+rs.getString("IMG_NAME"));
					System.out.println("rs.getString(\"IMG_SEQ\")"+rs.getString("IMG_SEQ"));
					
					((ImageBean) o).setUserid(rs.getString("USERID"));
					((ImageBean) o).setExtension(rs.getString("EXTENSION"));
					((ImageBean) o).setImgname(rs.getString("IMG_NAME"));
					((ImageBean) o).setImgseq(rs.getString("IMG_SEQ"));
					System.out.println("RetrieveQuery endPlay IMAGE 결과물 : "+o);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
}
