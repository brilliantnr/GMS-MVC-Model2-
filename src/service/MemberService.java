package service;

import java.util.*;
import domain.*;

public interface MemberService {
	public void createMember(MemberBean member);
	public List<MemberBean> listMember();
	public List<MemberBean> readMemberByName(String name);
	public MemberBean findMemberId(MemberBean member);
	public int countMember();
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
	public boolean login(MemberBean member);
	public List<MemberBean> searchTeamByName(String teamName);
	public List<MemberBean> searchMemberByWord(String word);
}
