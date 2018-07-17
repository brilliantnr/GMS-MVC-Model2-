package dao;

import java.util.List;

import domain.*;

public interface MemberDao {
	public void insertMember(MemberBean member);
	public List<MemberBean> listMember();
	public List<MemberBean> selectMemberByName(String name);
	public MemberBean findId(String name ,String ssn);
	public MemberBean selectMemberById(String id);
	public int countMember();
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
	public MemberBean login(MemberBean bean);
	public List<MemberBean> searchTeamByName(String teamName);
}
