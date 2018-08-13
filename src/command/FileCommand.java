package command;

import javax.servlet.http.HttpServletRequest;

public class FileCommand extends Command {
	public FileCommand(HttpServletRequest request) {
		System.out.println("4. FileCommand 진입");
		setRequest(request); 
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		excute();
		
	}
	@Override
	public void excute() {
		super.excute();
		request.setAttribute("pagename", request.getParameter("page"));
	}
}
