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
		MemberDaoImpl.getInstance().insert(bean);
	}
	@Override
	public List<MemberBean> search(Map<?, ?> param) {
		return MemberDaoImpl.getInstance().selectSome(param);
	}
	@Override
	public MemberBean retrieve(String id) {
		return MemberDaoImpl.getInstance().selectOne(id);
	}
	@Override
	public int count() {
		return MemberDaoImpl.getInstance().count();
	}
	@Override
	public void modify(Map<?, ?> param) {
		MemberDaoImpl.getInstance().update(param);
	}
	@Override
	public void remove(MemberBean bean) {
		MemberDaoImpl.getInstance().delete(bean);
	}
	@Override
	public boolean login(MemberBean bean) {
		boolean flag = false;
        MemberBean mem = MemberDaoImpl.getInstance().login(bean);
        System.out.println("----serviceImpl login : "+ mem.getUserid());
        if(mem.getUserid()!=null) {
             flag = true;
        }else {
             flag=false;
        }
        
        return flag;
	}
	
}
