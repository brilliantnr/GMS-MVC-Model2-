package command;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;

public class CountCommand extends Command{

	public CountCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		excute();
	}
	@Override
	public void excute() {
		request.setAttribute("count", MemberServiceImpl.getInstance().count());
		System.out.println("----CountCommand excute----");
		super.excute();
	}
	
}
