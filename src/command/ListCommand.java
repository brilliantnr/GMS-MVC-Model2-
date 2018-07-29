package command;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import domain.*;
import service.*;

public class ListCommand extends Command {
	List<MemberBean> list;
	public ListCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		excute();
	}
	
	@Override
	public void excute() {
		//List<MemberBean> lst = new ArrayList<>();
		request.setAttribute("list", MemberServiceImpl.getInstance().listMember());
		System.out.println("----리스트커맨드 excute----");
		MemberServiceImpl.getInstance().listMember();
		super.excute();
	}
}
