package command;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import enums.Domain;
import service.MemberServiceImpl;

public class ModifyCommand extends Command {

	public ModifyCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		excute();
	}
	@Override
	public void excute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			/*MemberBean member =new MemberBean();
			member = (MemberBean) request.getSession().getAttribute("user");
			System.out.println("---updateCommand 전\n :"+member);
			member.setPassword(request.getParameter("update_pw"));
			member.setTeamId(request.getParameter("teamid"));
			member.setRoll(request.getParameter("roll"));
			System.out.println("---updateCommand 후\n :"+member);*/
			Map<String, Object> map = new HashMap<>();
			map.put("user", request.getSession().getAttribute("user"));
			map.put("password", request.getParameter("update_pw"));
			map.put("teamId", request.getParameter("teamid"));
			map.put("roll", request.getParameter("roll"));
			
			
			map.put("column", 
					request.getParameter("아직 미완성입니다"));
			
			MemberServiceImpl.getInstance().modify(map);
			break;
		default:
			break;
		}
		super.excute();
	}
}



















/*case MEMBER: //비밀번호만 변경할때
MemberBean member =new MemberBean();
member.setUserid(request.getParameter("update-check-id"));
member.setPassword(request.getParameter("update-old-password")+"/"+request.getParameter("update-new-password"));
MemberServiceImpl.getInstance().updateMember(member);
break;*/