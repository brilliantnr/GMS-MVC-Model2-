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
//		List<MemberBean> list = MemberServiceImpl.getInstance().listMember();   // list에 service에서 받은 값을 담는다
		request.setAttribute("list", MemberServiceImpl.getInstance().listMember());  //★★★★  ${}안에 list를 넣어서 호출할거다 
		System.out.println("----리스트커맨드 excute----");
		super.excute();
	}
}
