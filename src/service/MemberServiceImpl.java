package service;

import java.util.*;
import dao.*;
import domain.*;

public class MemberServiceImpl implements MemberService{

	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {
	}
	@Override
	public void add(MemberBean bean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<MemberBean> search(Map<?, ?> param) {
		return MemberDaoImpl.getInstance().selectSome(param);
	}
	@Override
	public MemberBean retrieve(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void modify(Map<?, ?> param) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(MemberBean bean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean login(MemberBean bean) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
