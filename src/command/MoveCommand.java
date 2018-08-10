package command;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	//상속받아야 한다!
	
	public MoveCommand(HttpServletRequest request) {  //생성자에 request
		setRequest(request); 
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		excute();
		System.out.println("4. moveCommand action : "+request.getParameter("action"));
		System.out.println("4. moveCommand page : "+request.getParameter("page"));
	}
	@Override
	public void excute() {
		super.excute();
		request.setAttribute("pagename", request.getParameter("page"));
	}
}
