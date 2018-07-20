package command;

import javax.servlet.http.HttpServletRequest;

import domain.*;
import enums.*;
import service.MemberServiceImpl;


public class LoginCommand extends Command {
	public LoginCommand(HttpServletRequest request) {  //커맨드 리퀘스트
		setRequest(request);  //커맨드리퀘스트가 담김
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		excute();
	}
	@Override
	public void excute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			MemberBean member=new MemberBean();
			member.setUserid(request.getParameter("user-id"));
			member.setPassword(request.getParameter("user-password"));
			MemberServiceImpl.getInstance().login(member);
			break;
		default:
			break;
		}
		super.excute();
		
		
/*선생님 코드 (login타입 boolean 이다)
 * 		super.excute();
		MemberBean member = new MemberBean();
		member.setUserid(request.getParameter("user-id"));
		member.setPassword(request.getParameter("user-password"));
		if(MemberServiceImpl.getInstance().login(member)) {
			request.setAttribute("match", "TRUE");
			request.setAttribute("user", MemberServiceImpl.getInstance().findMemberId(member));
			else {
				request.setAttribute("match", "FALSE");
			}
		}
		*/
		
		
		
		
		
		
		
		
	}
}