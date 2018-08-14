package template;

import java.sql.ResultSet;
import domain.MemberBean;
import enums.ImageQuery;
import enums.MemberQuery;

public class RetrieveQuery extends QueryTemplate {

	@Override
	void initialize() {
		switch (map.get("table").toString()) {
		case "MEMBER":
			System.out.println("--RetrieveQuery -MEMBER진입 ");
			map.put("sql", MemberQuery.RETRIEVE.toString());
			/*
			 * " SELECT " + ColumnFinder.find(Domain.MEMBER) + " FROM MEMBER " +
			 * " WHERE USERID LIKE ? "
			 */
			break;
		case "IMAGE":
			System.out.println("--RetrieveQuery -IMAGE진입1 ");
			map.put("sql", ImageQuery.RETRIEVE.toString());
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
				String id = (String) map.get("id");
				System.out.println("RetrieveQuery id : " + id);
				pstmt.setString(1, id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "IMAGE":
			try {
				System.out.println("RetrieveQuery IMAGE 진입2");
				pstmt.setString(1, (String) map.get("userid"));
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
		switch (map.get("table").toString()) {
		case "MEMBER":
			try {
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					((MemberBean) o).setAge(rs.getString("AGE"));
					((MemberBean) o).setName(rs.getString("NAME"));
					((MemberBean) o).setPassword(rs.getString("PASSWORD"));
					((MemberBean) o).setRoll(rs.getString("ROLL"));
					((MemberBean) o).setSsn(rs.getString("SSN"));
					((MemberBean) o).setUserid(rs.getString("USERID"));
					((MemberBean) o).setTeamId(rs.getString("TEAMID"));
					((MemberBean) o).setGender(rs.getString("GENDER"));
					((MemberBean) o).setSubject(rs.getString("SUBJECT"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "IMAGE":
			try {
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					((MemberBean) o).setUserid(rs.getString("USERID"));
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
