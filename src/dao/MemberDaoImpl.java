package dao;

import java.sql.*;
import java.util.*;
import domain.*;
import enums.*;
import factory.*;
import pool.DBConstant;
import template.*;
//★ MemberQuery.LOGIN.toString() <- Enum 사용 
//select 는 리턴타입 void 아니라서 executeQuery   리턴타입필요하니까  resultset 쓴다
//insert,update,delete는 리턴타입 void 니까
//-> .executeUpdate(sql) 로 사용해야함.

public class MemberDaoImpl implements MemberDao{
	private static MemberDao instance = new MemberDaoImpl();
	public static MemberDao getInstance() {return instance;}
	private MemberDaoImpl() {
	}
			
	@Override
	public MemberBean login(MemberBean bean) {
		MemberBean m = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE,
					DBConstant.USERNAME,
					DBConstant.PASSWORD)
			.getConnection().createStatement().executeQuery(String.format(
					MemberQuery.LOGIN.toString(),
					bean.getUserid(), bean.getPassword()));    
			System.out.println("쿼리 : "+MemberQuery.LOGIN.toString());
			System.out.println("5. dao 진입/  while(rs.next) 전 ");

			while(rs.next()) {
				m=new MemberBean();
				m.setUserid(rs.getString("USERID"));
				m.setName(rs.getString("NAME"));
				m.setPassword(rs.getString("PW"));
				m.setSsn(rs.getString("SSN"));
				m.setAge(rs.getString("AGE"));
				m.setGender(rs.getString("GENDER"));
				m.setTeamId(rs.getString("TEAMID"));
				m.setRoll(rs.getString("ROLL"));
				System.out.println("5. DAO m.getPassword:"+m.getPassword());
				System.out.println("5. DAO rs.getString:"+rs.getString("PW"));
				System.out.println("5. DAO login---\n : "+m);
				}
			} catch (Exception e) { e.printStackTrace();}
		return m;
	}	

	@Override
	public void insertMember(MemberBean member) {
		try {
			System.out.println("gender : "+ member.getGender());
			System.out.println("age : "+ member.getAge());
			int rs=
			DatabaseFactory.createDatabase(
					Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection().createStatement().executeUpdate(
					String.format(MemberQuery.INSERT_MEMBER.toString(),
							member.getUserid(), member.getName(), member.getSsn(), member.getPassword(),
							member.getTeamId(), member.getRoll(), member.getGender(), member.getAge()));
			System.out.println("5. Dao 가입결과:"+rs);
		} catch (Exception e) {e.printStackTrace();}
	}

	@Override
	public List<MemberBean> listMember() {
		List<MemberBean> lst =new ArrayList<>();
		System.out.println("5. DAO listMember --진입");
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection().createStatement().executeQuery(MemberQuery.SELECT_ALL.toString());
			MemberBean mem = null;
			while(rs.next()) {
				mem = new MemberBean(); //매번 새로담기
				mem.setAge(rs.getString("AGE"));
				mem.setName(rs.getString("NAME"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setSsn(rs.getString("SSN"));
				mem.setUserid(rs.getString("USERID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setGender(rs.getString("GENDER"));
				lst.add(mem);
			}
			
		} catch (Exception e) {e.printStackTrace();}

		return lst;
	}

	@Override
	public List<MemberBean> selectMemberByName(String name) {
		List<MemberBean> lst =new ArrayList<>();
		System.out.println("5. DAO selectMemberByName --진입");
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection().createStatement().executeQuery(MemberQuery.SELECT_BY_NAME.toString());
			MemberBean mem = null;
			while(rs.next()) {
				mem.setUserid(rs.getString("USERID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setAge(rs.getString("AGE"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setSsn(rs.getString("SSN"));
				mem.setGender(rs.getString("GENDER"));
				lst.add(mem);
			}
		} catch (Exception e) {e.printStackTrace();}
		return lst;
	}


	@Override
	public int countMember() {
		int count = 0;
		System.out.println("5. DAO countMember --진입");
		try {
			/*Class.forName(DBConstant.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection("","","");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("");
			while(rs.next()) {
			}
			이 기본형은 굉장히 느린 것. 
			*/
			ResultSet rs =
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection().createStatement().executeQuery(MemberQuery.COUNT_MEMBER.toString());
			
			while(rs.next()) {
				count = rs.getInt("count");  // sql문에서 as count라고 명명했음
			}
		} catch (Exception e) {e.printStackTrace();}
		return count;
	}

	@Override
	public void updateMember(MemberBean member) {
		System.out.println("5. DAO Update Member--");
		//비밀번호 바꾸는 것
		try {
			System.out.println("--쿼리실행--");
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection().createStatement().executeUpdate(String.format(
					MemberQuery.UPDATE_PW.toString(),
					member.getPassword(),
					member.getTeamId(),
					member.getRoll(),
					member.getUserid()
							)
					);
			System.out.println("--쿼리완료--");
			System.out.println("5. dao 업데이트   :"+member);
		} catch (Exception e) {e.printStackTrace();}
	}
	/*
	" UPDATE MEMBER " + 
					" SET " + 
					" PASSWORD = '%s'," + 
					" TEAM_ID = '%s'," + 
					" ROLL = '%s' " + 
					" WHERE MEM_ID LIKE '%s' ";
					*/
	

	@Override
	public void deleteMember(MemberBean member) {
		System.out.println("5. DAODeleteMember---"+member);
		try {
			System.out.println("--쿼리접속--");
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection().createStatement().executeUpdate(String.format(
							MemberQuery.DELETE_MEMBER.toString(),member.getUserid()));
			System.out.println("--쿼리완료--");
		} catch (Exception e) {e.printStackTrace();}
	
	}
	@Override
	public MemberBean findMemberId(MemberBean mem) {
		MemberBean m = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE,
					DBConstant.USERNAME,
					DBConstant.PASSWORD)
			.getConnection().createStatement().executeQuery(String.format(
					MemberQuery.FIND_ID.toString(),
					mem.getUserid()));    

			while(rs.next()) {
				m=new MemberBean();
				m.setUserid(rs.getString("USERID"));
				m.setTeamId(rs.getString("TEAMID"));
				m.setName(rs.getString("NAME"));
				m.setAge(rs.getString("AGE"));
				m.setGender(rs.getString("GENDER"));
				m.setSsn(rs.getString("SSN"));
				m.setRoll(rs.getString("ROLL"));
				m.setPassword(rs.getString("PW"));
				System.out.println("5. DAO findMemberId---\n  : "+m);
				}
			} catch (Exception e) { e.printStackTrace();}
		return m;
	}
	@Override
	public MemberBean selectMemberById(String id) {
		MemberBean member = new MemberBean();
		System.out.println("5. DAO search id--");
		try {
			System.out.println("--쿼리접속--");
			ResultSet rs =
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection().createStatement().executeQuery((String.format(MemberQuery.SEARCH_ID.toString(), id)));
			while(rs.next()) {
				member.setAge(rs.getString("AGE"));
				member.setName(rs.getString("NAME"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setRoll(rs.getString("ROLL"));
				member.setTeamId(rs.getString("TEAMID"));
				member.setUserid(rs.getString("USERID"));
			}
			
			
			System.out.println("--쿼리완료--");
			
		} catch (Exception e) {e.printStackTrace();}
		return member;
	}
	@Override
	public List<MemberBean> searchTeamByName(String teamName) {
		List<MemberBean> lst=new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection().createStatement().executeQuery(String.format(
							MemberQuery.SEARCH_TEAM.toString(),teamName));
			MemberBean mem = null;
			while(rs.next()) {
				mem.setUserid(rs.getString("MEM_ID"));
				mem.setName("NAME");
				lst.add(mem);
			}
		} catch (Exception e) {	e.printStackTrace();}
		/*SELECT MEM_ID ,NAME
	    FROM MEMBER
	    WHERE TEAM_ID LIKE 'A';*/
		return lst;
	}
	@Override
	public List<MemberBean> searchMemberByWord(String word) {
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list=new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		map.put("column", word.split("/")[0]);
		map.put("value", word.split("/")[1]);
		map.put("table",Domain.MEMBER);
		q.play(map);
		for(Object s: q.getList()) {
			list.add((MemberBean) s);
		}
		return list;
	}
/*	@Override
	public List<MemberBean> searchMemberByWord(String word) {
		List<MemberBean> lst=new ArrayList<>();
		String query = " SELECT " + 
				" MEM_ID USERID, " + 
				" TEAM_ID TEAMID, " + 
				" NAME, " + 
				" AGE, " + 
				" ROLL, " +
				" GENDER, " +
				" SSN " + 
				" FROM MEMBER " + 
				"  WHERE "+word.split("/")[0]+" LIKE '%"+word.split("/")[1]+"%'";
		try {
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection().createStatement().executeQuery(query);
			MemberBean m = null;
			while(rs.next()) {
				m=new MemberBean();
				m.setUserid(rs.getString("USERID"));
				m.setTeamId(rs.getString("TEAMID"));
				m.setName(rs.getString("NAME"));
				m.setAge(rs.getString("AGE"));
				m.setGender(rs.getString("GENDER"));
				m.setSsn(rs.getString("SSN"));
				m.setRoll(rs.getString("ROLL"));
				System.out.println("5. DAO findMemberId---\n  : "+m);
				lst.add(m);
			}
		} catch (Exception e) {	e.printStackTrace();}
		SELECT MEM_ID ,NAME
	    FROM MEMBER
	    WHERE TEAM_ID LIKE 'A';
		return lst;
	
	}*/
	@Override
	public List<MemberBean> selectList(Map<?, ?> param) {
		List<MemberBean> list = new ArrayList<>();
		int beginRow =  (int) param.get("beginRow");
		int endRow =  (int) param.get("endRow");
		
		System.out.println("--beginRow : "+beginRow);
		System.out.println("--endRow : "+endRow);
		
		QueryTemplate q= new PstmtQuery();
		HashMap<String,Object> map = new HashMap<>();
		map.put("table","(SELECT ROWNUM SEQ, M.* FROM MEMBER M ORDER BY SEQ DESC) MEMBER");
		map.put("column", " MEMBER.SEQ BETWEEN "+beginRow+" AND "+endRow);
		q.play(map);
		for(Object s : q.getList()) {
			list.add((MemberBean) s);
		}
		return list;
	}
}
