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
	public boolean login(MemberBean member) {
		boolean flag = false;
		MemberBean mem = MemberDaoImpl.getInstance().login(member);
		System.out.println("----serviceImpl login : "+ mem);
		if(mem != null) {
			flag = true;
		}else {
			flag=false;
		}
		
		return flag;
	}
		/*public boolean login(MemberBean member) {
		boolean flag = flase;
		if(MemberDaoImpl.getInstance().login(member)==null){
			flag=true;
		};
		return falg;
		*/
	public boolean checkId(MemberBean member) {
		return (MemberDaoImpl.getInstance().login(member)!=null);	
	}
	
	@Override
	public void createMember(MemberBean member) {
		MemberDaoImpl.getInstance().insertMember(member);
	}

	@Override
	public List<MemberBean> listMember() {
		return MemberDaoImpl.getInstance().listMember();
	}

	@Override
	public List<MemberBean> readMemberByName(String name) {
		return MemberDaoImpl.getInstance().selectMemberByName(name);
	}

	@Override
	public MemberBean findMemberId(MemberBean member) {
		return MemberDaoImpl.getInstance().findMemberId(member);
		
	}

	@Override
	public int countMember() {
		return MemberDaoImpl.getInstance().countMember();
	}

	@Override
	public void updateMember(MemberBean member) {
		System.out.println("--Service.Update--");
		String[] arr = member.getPassword().split("/");
		//arr[0]=pass, arr[1]=newPw
		MemberDaoImpl.getInstance().updateMember(member);
		System.out.println("service 이전비번과 다름. 성공"+member);
	/*
		if(!arr[0].equals(arr[1])) {
			MemberDaoImpl.getInstance().updateMember(member);
			System.out.println("service 이전비번과 다름. 성공"+member);
		}*/
		
	}

	@Override
	public void deleteMember(MemberBean member) {
		System.out.println("--Service.Delete--");
		MemberDaoImpl.getInstance().deleteMember(member);
	}
	@Override
	public List<MemberBean> searchTeamByName(String teamName) {
		return MemberDaoImpl.getInstance().searchTeamByName(teamName);
	}
	@Override
	public List<MemberBean> searchMemberByWord(String word) {
		return MemberDaoImpl.getInstance().searchMemberByWord(word);
	}
	@Override
	public List<MemberBean> getList(Map<?, ?> param) {
		return MemberDaoImpl.getInstance().selectList(param);
	}


		
	
}
