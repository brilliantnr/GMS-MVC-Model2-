package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class DeleteCommand extends Command {
	public DeleteCommand(HttpServletRequest request) {
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
			member.setUserid(request.getParameter("delete-id"));
			member.setPassword(request.getParameter("delete-pw"));
			MemberServiceImpl.getInstance().deleteMember(member);
			break;
		default:
			break;
		}
		super.excute();
	}
}
