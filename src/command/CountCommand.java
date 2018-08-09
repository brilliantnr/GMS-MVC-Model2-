package command;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;

public class CountCommand extends Command{

	public CountCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		excute();
	}
	@Override
	public void excute() {
		request.setAttribute("count", MemberServiceImpl.getInstance().count());
		System.out.println("----카운트커맨드 excute----");
		super.excute();
	}
	
}
