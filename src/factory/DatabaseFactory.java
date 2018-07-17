package factory;
import enums.Vendor;
import pool.DBConstant;

public class DatabaseFactory {
	 public static Database createDatabase(Vendor v,String id, String pass) {
		 Database db =null;
		 switch (v) {
		case ORACLE:
			//temp = new Oracle();
			//어떻게 conn을 리턴받게 할까
			db = new Oracle(DBConstant.ORACLE_DRIVER, DBConstant.CONNECTION_URL, id, pass);
			break;
		case MARIADB:
			db = new MariaDB(DBConstant.MariaDB_DRIVER, DBConstant.CONNECTION_URL, id, pass);
			break;
		case MYSQL:
			db = new MySQL(DBConstant.MySQL_DRIVER, DBConstant.CONNECTION_URL, id, pass);
			break;
		case MSSQL:

			break;		
		}
		 return db;
	 }
}
