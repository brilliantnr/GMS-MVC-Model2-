package dao;

import java.util.*;

import domain.*;

public interface MemberDao {
	public void insertMember(MemberBean member);
	public List<MemberBean> listMember();
	public List<MemberBean> selectList(Map<?, ?>param);
	public List<MemberBean> selectMemberByName(String name);
	public MemberBean findMemberId(MemberBean member);
	public MemberBean selectMemberById(String id);
	public int countMember();
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
	public MemberBean login(MemberBean bean);
	public List<MemberBean> searchTeamByName(String teamName);
	public List<MemberBean> searchMemberByWord(String word);
}
