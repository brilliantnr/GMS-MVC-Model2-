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
					" MEM_ID USERID, " + 
					" NAME, " + 
					" PASSWORD PW, " + 
					" SSN, " + 
					" AGE, " + 
					" TEAM_ID TEAMID, " + 
					" GENDER, " +
					" ROLL " +
					" FROM MEMBER " + 
					"  WHERE MEM_ID LIKE '%s' AND PASSWORD LIKE '%s'   ";
			break;
		case INSERT_MEMBER:
			query =" INSERT INTO MEMBER(" + 
					" MEM_ID, " + 
					" NAME, " + 
					" SSN, " + 
					" PASSWORD, " + 
					" TEAM_ID, " + 
					" ROLL, " + 
					" GENDER, " + 
					" AGE   " + 
					" ) VALUES " + 
					" ('%s' ,'%s' ,'%s' ,'%s','%s','%s','%s','%s' ) ";
			break;
			
		case FIND_ID:
			query = " SELECT " + 
					" MEM_ID USERID, " + 
					" TEAM_ID TEAMID, " + 
					" NAME, " + 
					" AGE, " + 
					" GENDER, " + 
					" ROLL, " +
					" PASSWORD PW ," + 
					" SSN " + 
					" FROM MEMBER " + 
					" WHERE MEM_ID LIKE '%s' ";
			break;
		case COUNT_MEMBER:
			query = "  SELECT COUNT(*) AS count FROM MEMBER ";
			break;
		case UPDATE_PW:
			query = " UPDATE MEMBER " + 
					" SET " + 
					" PASSWORD = '%s', " + 
					" TEAM_ID = '%s', " + 
					" ROLL = '%s' " + 
					" WHERE MEM_ID LIKE '%s' ";
			break;	
		case DELETE_MEMBER:
			query = "  DELETE FROM MEMBER " + 
					"  WHERE MEM_ID LIKE '%s' ";
			break;		
		case SELECT_ALL:
			query = " SELECT " + 
					" MEM_ID USERID, " + 
					" TEAM_ID TEAMID, " + 
					" NAME, " + 
					" AGE, " + 
					" ROLL, " +
					" PASSWORD, " + 
					" GENDER, " + 
					" SSN " + 
					" FROM MEMBER ";
			break;
		case SELECT_BY_NAME:
			query = " SELECT " + 
					" MEM_ID USERID, " + 
					" TEAM_ID TEAMID, " + 
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
			query = "SELECT MEM_ID ,"
					+ " NAME " + 
					" FROM MEMBER " + 
					" WHERE TEAM_ID LIKE '%s' ";
			break;
		case SELECT_BY_WORD:
			query = " SELECT " + 
					" MEM_ID USERID, " + 
					" TEAM_ID TEAMID, " + 
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
