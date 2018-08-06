package enums;

public enum MemberQuery {
	//ctrl+spacebar 로 toString 나타냄(객체를 내부적으로 상속받았을 때에 나타남. 인터페이스에선 안나옴)
	//object class 가 defualt로 
	//Enum,class 동급 =>>  object calss 는 객체의 조상이다.
	
	LOGIN, INSERT_MEMBER,FIND_ID,COUNT_MEMBER,UPDATE_PW,DELETE_MEMBER, SELECT_ALL, SELECT_BY_NAME, SEARCH_TEAM,SEARCH_ID, SELECT_BY_WORD;

	@Override
	public String toString() {
		String query ="";
		switch (this) {
		case LOGIN:
			query = " SELECT " + 
					" USERID, " + 
					" NAME, " + 
					" PASSWORD PW, " + 
					" SSN, " + 
					" AGE, " + 
					" TEAMID, " + 
					" GENDER, " +
					" ROLL " +
					" FROM MEMBER " + 
					"  WHERE LIKE '%s' AND PASSWORD LIKE '%s'   ";
			break;
		case INSERT_MEMBER:
			query =" INSERT INTO MEMBER(" + 
					" USERID, " + 
					" NAME, " + 
					" SSN, " + 
					" PASSWORD, " + 
					" TEAMID , " + 
					" ROLL, " + 
					" GENDER, " + 
					" AGE   " + 
					" ) VALUES " + 
					" ('%s' ,'%s' ,'%s' ,'%s','%s','%s','%s','%s' ) ";
			break;
			
		case FIND_ID:
			query = " SELECT " + 
					" USERID, " + 
					" TEAMID, " + 
					" NAME, " + 
					" AGE, " + 
					" GENDER, " + 
					" ROLL, " +
					" PASSWORD PW ," + 
					" SSN " + 
					" FROM MEMBER " + 
					" WHERE LIKE '%s' ";
			break;
		case COUNT_MEMBER:
			query = "  SELECT COUNT(*) AS count FROM MEMBER ";
			break;
		case UPDATE_PW:
			query = " UPDATE MEMBER " + 
					" SET " + 
					" PASSWORD = '%s', " + 
					" = '%s', " + 
					" ROLL = '%s' " + 
					" WHERE LIKE '%s' ";
			break;	
		case DELETE_MEMBER:
			query = "  DELETE FROM MEMBER " + 
					"  WHERE LIKE '%s' ";
			break;		
		case SELECT_ALL:
			query = " SELECT T.* FROM (SELECT ROWNUM SEQ, " + 
					" M.* " + 
					" FROM MEMBER M " + 
					" ORDER BY SEQ DESC) T " + 
					" WHERE T.SEQ BETWEEN 1 AND 5 ";
			break;
		case SELECT_BY_NAME:
			query = " SELECT " + 
					" USERID, " + 
					" TEAMID, " + 
					" NAME, " + 
					" AGE, " + 
					" ROLL, " +
					" GENDER, " +
					" PASSWORD PW ," + 
					" SSN " + 
					" FROM MEMBER " + 
					"  WHERE NAME LIKE '%s' ";
			break;
		case SEARCH_TEAM:
			query = "SELECT ,"
					+ " NAME " + 
					" FROM MEMBER " + 
					" WHERE LIKE '%s' ";
			break;
		case SELECT_BY_WORD:
			query = " SELECT " + 
					" USERID, " + 
					" TEAMID, " + 
					" NAME, " + 
					" AGE, " + 
					" ROLL, " +
					" GENDER, " +
					" SSN " + 
					" FROM MEMBER " + 
					"  WHERE '%s' LIKE '%s' ";
			break;
		}
		return query;
	}
	
}
