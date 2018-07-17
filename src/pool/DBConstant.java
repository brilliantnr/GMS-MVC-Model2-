package pool;

public class DBConstant {
	//static final 을 많이 사용하는 것은 좋지 않다. 메모리 점유하기 때문에
	
	public static final String ORACLE_DRIVER="oracle.jdbc.driver.OracleDriver";
	public static final String MySQL_DRIVER="";
	public static final String MariaDB_DRIVER="";
	
	public static final String CONNECTION_URL="jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USERNAME="rachel";
	public static final String PASSWORD="7003";
}
