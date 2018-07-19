package command;

import javax.servlet.http.HttpServletRequest;

import domain.*;
import enums.*;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command {

	public RetrieveCommand(HttpServletRequest request) {
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
			MemberBean member = new MemberBean();
			member.setName(request.getParameter("search-id-name"));
			member.setSsn(request.getParameter("search-id-birth"));
			request.setAttribute("retrieve", MemberServiceImpl.getInstance().findMemberId(member));
			//MemberServiceImpl.getInstance().findMemberId(member);
			break;
		default:
			break;
		}
		super.excute();
	
	}
}
