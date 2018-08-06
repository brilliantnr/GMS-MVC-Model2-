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
		//List<MemberBean> list = MemberServiceImpl.getInstance().listMember();   // list에 service에서 받은 값을 담는다
		int beginpage=1;
		int endpage =5;
		int rowCount =MemberServiceImpl.getInstance().countMember();
		//int rowCount = 10;
		int totalpage =(int) Math.ceil(rowCount/5);
		if(totalpage>5) {endpage=5;}else {endpage=totalpage;}
		
		Map<String, Object> param = new HashMap<>();
		String beginRow = "1";
		String endRow = "5";
		int nowPage = 4;
		beginRow = String.valueOf((nowPage-1) * 5 + 1);
		endRow = String.valueOf(nowPage * 5);
		param.put("beginRow", beginRow);
		param.put("endRow", endRow);
		List<MemberBean> mems = MemberServiceImpl.getInstance().getList(param);
		
		request.setAttribute("list", MemberServiceImpl.getInstance().listMember());  //★★★★  ${}안에 list를 넣어서 호출할거다 
		request.setAttribute("count", MemberServiceImpl.getInstance().countMember());
		request.setAttribute("beginPage", beginpage);
		request.setAttribute("endPage", endpage);
		request.setAttribute("totalPage", totalpage);
		//request.setAttribute("listPage", Math.ceil(count/5)); 전체페이지수
		//System.out.println("endPage = "+request.getAttribute("endPage"));
		//System.out.println("----리스트커맨드 excute----");
		super.excute();
	}
}
