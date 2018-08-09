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
	public void add(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		List<MemberBean> list = new ArrayList<>();
        int beginRow =  (int) param.get("beginRow");
        int endRow =  (int) param.get("endRow");
        System.out.println("DAO beginRow :"+beginRow);
        System.out.println("DAO endRow :"+endRow);
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
	@Override
	public MemberBean selectOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void update(Map<?, ?> param) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(MemberBean bean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public MemberBean login(MemberBean bean) {
		 MemberBean m = null;
		return m;
	}
			

}
