package dao;

import java.sql.*;
import java.util.*;
import domain.*;
import enums.*;
import factory.*;
import pool.DBConstant;
import template.*;
import template.CountQuery;
//★ MemberQuery.LOGIN.toString() <- Enum 사용 
//select 는 리턴타입 void 아니라서 executeQuery   리턴타입필요하니까  resultset 쓴다
//insert,update,delete는 리턴타입 void 니까
//-> .executeUpdate(sql) 로 사용해야함.

public class MemberDaoImpl implements MemberDao{
	private static MemberDao instance = new MemberDaoImpl();
	public static MemberDao getInstance() {return instance;}
	private MemberDaoImpl() {}
	private QueryTemplate q = null;
	
	@Override
	public void insert(MemberBean bean) {
		System.out.println("MemberDaoImpl insert --- ");
		q=new AddQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("member", bean);
		q.play(map);
	}
	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		System.out.println("MemberDaoImpl selectSome --- ");
		List<MemberBean> list = new ArrayList<>();
        q= new SearchQuery();
        q.play(param);
        for(Object s : q.getList()) {
             list.add((MemberBean) s);
        }
		return list;
	}
	@Override
	public MemberBean selectOne(String id) {
		System.out.println("MemberDaoImpl selectOne --- ");
		HashMap<String, Object> map = new HashMap<>();
		MemberBean m = new MemberBean();
		q= new RetrieveQuery();
		map.put("id", id);
		q.play(map);
		return m;
	}
	@Override
	public int count() {
		System.out.println("MemberDaoImpl count --- ");
		q = new CountQuery();
		q.play();
		return q.getNumber();
	}
	@Override
	public void update(Map<?, ?> param) {
		System.out.println("MemberDaoImpl update --- ");
		List<MemberBean> list = new ArrayList<>();
		q=new ModifyQuery();
		q.play(param);
		for(Object s : q.getList()) {
			list.add((MemberBean) s);
		};
	}
	@Override
	public void delete(MemberBean bean) {
		System.out.println("MemberDaoImpl delete : ");
		q=new RemoveQuery();
		// TODO Auto-generated method stub
		
	}
	@Override
	public MemberBean login(MemberBean bean) {
		System.out.println("MemberDaoImpl login : ");
		MemberBean m = null;
		// TODO Auto-generated method stub
		return m;
	}
			

}



/*
 * public List<MemberBean> selectSome(Map<?, ?> param) {
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
return list;*/
