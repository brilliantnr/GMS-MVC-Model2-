package command;

import javax.servlet.http.HttpServletRequest;

import domain.*;
import enums.*;
import service.MemberServiceImpl;


public class LoginCommand extends Command {
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		excute();
	}
	@Override
	public void excute() {
		switch (Domain.valueOf(Receiver.cmd.domain.toUpperCase())) {
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
	}
}
