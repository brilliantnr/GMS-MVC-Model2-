package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class UpdateCommand extends Command {

	public UpdateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		excute();
	}
	@Override
	public void excute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			MemberBean member =new MemberBean();
			member.setUserid(request.getParameter("update-check-id"));
			member.setPassword(request.getParameter("update-old-password")+"/"+request.getParameter("update-new-password"));
			MemberServiceImpl.getInstance().updateMember(member);
			break;
		default:
			break;
		}
		super.excute();
	}
}
