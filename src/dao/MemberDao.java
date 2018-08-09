package dao;

import java.util.*;

import domain.*;

public interface MemberDao {
	public void add(MemberBean member);
	public List<MemberBean> selectSome(Map<?, ?>param);
	public MemberBean selectOne(String id);
	public int count();
	public void update(Map<?, ?>param);
	public void delete(MemberBean bean);
	public MemberBean login(MemberBean bean);
}
