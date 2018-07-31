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
		excute();
	}
	@Override
	public void excute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			MemberBean member=new MemberBean();
			member.setUserid(((MemberBean) request.getSession().getAttribute("user")).getUserid());
			MemberServiceImpl.getInstance().deleteMember(member);
			request.getSession().invalidate();  //user로 설정해놓은 것이 logout 되는 것임
			System.out.println("DeleteCommand \n   :"+member);
			
			/*member.setUserid(request.getParameter("delete-id"));
			member.setPassword(request.getParameter("delete-pw"));*/
			break;
		default:
			break;
		}
		super.excute();
	}
}
