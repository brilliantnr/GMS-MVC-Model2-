package enums;

import template.ColumnFinder;

public enum MemberQuery {
	//ctrl+spacebar 로 toString 나타냄(객체를 내부적으로 상속받았을 때에 나타남. 인터페이스에선 안나옴)
	//object class 가 defualt로 
	//Enum,class 동급 =>>  object calss 는 객체의 조상이다.
	
	//SQL이니까 쿼리따라서 이름 달게요
	INSERT,
	LIST, SEARCH, RETRIEVE, COUNT,
	UPDATE,
	DELETE,
	LOGIN,;

	//템플릿패턴했을때의 쿼리
	
	@Override
	public String toString() {
		String query ="";
		switch (this) {
		case INSERT:
			//columnFinder를 써도 될까나
			//bean의 속성 쓴 순서대로인가????
			query =" INSERT INTO MEMBER("
					+" USERID, " + 
					" NAME, " + 
					" SSN, " + 
					" PASSWORD, " + 
					" TEAMID , " + 
					" ROLL, " + 
					" GENDER, " + 
					" AGE   "
					+ " ) VALUES "
					+ " (?,?,?,?,?,?,?,?) ";
			break;
		case LIST:
			query = " SELECT T.* FROM (SELECT ROWNUM SEQ, "
					+ " M.* " 
					+ " FROM MEMBER M "
					+ " ORDER BY SEQ DESC) T "  
					+ " WHERE T.SEQ BETWEEN ? AND ? ";
			break;
		case SEARCH:
			query = " SELECT T.* FROM (SELECT ROWNUM SEQ, " + 
					" M.* " + 
					" FROM MEMBER M " + 
					" WHERE %s LIKE ? "+
					" ORDER BY SEQ DESC) T " + 
					" WHERE T.SEQ BETWEEN ? AND ? ";
			break;
		case RETRIEVE:
			query = " SELECT "
					+ ColumnFinder.find(Domain.MEMBER)
					+ " FROM MEMBER " 
					+ " WHERE USERID LIKE ? "
					;
			break;
		case COUNT:
			query = "  SELECT COUNT(*) AS count FROM MEMBER ";
			break;
		case UPDATE:
			query = " UPDATE  "
					+ " MEMBER SET %s = ? "
					+ " WHERE USERID LIKE ? "
					;
			break;	
		case DELETE:
			query = "  DELETE "
					+ " FROM MEMBER "
					+ " WHERE USERID LIKE ? "
					+ " AND PASSWORD LIKE ? "
					;
			break;		
		case LOGIN:
			query = " SELECT "
					+ ColumnFinder.find(Domain.MEMBER)
					+ " FROM MEMBER "
					+ " WHERE USERID LIKE ? "
					+ " AND PASSWORD LIKE ? ";
			break;
		}
		return query;
	}
	
}
