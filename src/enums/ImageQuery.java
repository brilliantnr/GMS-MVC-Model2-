package enums;

import template.ColumnFinder;

public enum ImageQuery {
	INSERT,
	RETRIEVE,
	UPDATE,
	DELETE
	;
	
	@Override
	public String toString() {
		String query = "";
		switch (this) {
		case INSERT:
			query = " INSERT INTO IMAGE( "
					+ " IMG_SEQ "
					+ " ,IMG_NAME "
					+ " ,EXTENSION "
					+ " ,USERID "
					+ " ) VALUES ( "
					+ "IMG_SEQ.NEXTVAL , ? , ? , ? )"
					;
			break;
		case RETRIEVE:
			query = " SELECT * " + 
					"FROM " + 
					"( " + 
					" SELECT * " + 
					" FROM IMAGE " + 
					" WHERE USERID LIKE ? " + 
					" ORDER BY IMG_SEQ DESC " + 
					") " + 
					"WHERE ROWNUM = 1 "
					;
			break;
		case UPDATE:
			query = " UPDATE  "
					+ " IMAGE SET %s = ? "
					+ " WHERE USERID LIKE ? "
					;
			break;
		case DELETE:
			query = "  DELETE "
					+ " FROM IMAGE "
					+ " WHERE USERID LIKE ? "
					;
			break;
		}
		return query;
	}
	
	
}
