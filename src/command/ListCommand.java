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
		// List<MemberBean> list = MemberServiceImpl.getInstance().listMember(); //list에 service에서 받은 값을 담는다
		Map<String, Object> param = new HashMap<>();
		int rowCount = MemberServiceImpl.getInstance().countMember();
		int pageSize = 5;
		int pageNum = (request.getParameter("pageNum") == null) ? 1 : Integer.parseInt(request.getParameter("pageNum"));
		int pageCount = (int) Math.ceil(rowCount / pageSize);
		
		int beginPage = 1;
		int endPage = (pageCount > pageSize) ? pageSize : pageCount;
		int prevBlock = beginPage-pageSize;
		int nextBlock = beginPage+pageSize;
		int beginRow = (pageNum - 1) * pageSize + 1;
		int endRow = pageNum * pageSize;
		
		System.out.println(" 현재페이지 : "+pageNum+" \n 총페이지수 : "+pageCount);
		System.out.println(" 시작페이지 : "+beginPage+" \n 끝페이지 : "+endPage);
		System.out.println(" 시작로우 : "+beginRow+" \n 끝로우 : "+endRow);

		boolean existPrev=false;
		boolean existNext=false;
		if(prevBlock >=0) {
			existPrev=true;
		}else {
			if(nextBlock <= pageCount) {
				existNext=true;
			}
		}
		
		param.put("beginRow", beginRow);
		param.put("endRow", endRow);
		List<MemberBean> mems = MemberServiceImpl.getInstance().getList(param);
		request.setAttribute("list", mems); // ★★★★ ${}안에 list를 넣어서 호출할거다
		
		request.setAttribute("count", MemberServiceImpl.getInstance().countMember());
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageSize", pageSize);
		// System.out.println("endPage = "+request.getAttribute("endPage"));
		// System.out.println("----리스트커맨드 excute----");
		super.excute();
	}
}
