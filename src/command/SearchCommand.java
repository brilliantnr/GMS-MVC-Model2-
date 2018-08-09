package command;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import domain.*;
import proxy.*;
import service.*;

public class SearchCommand extends Command {
	List<MemberBean> list;
	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		excute();
	}
	
	@Override
	public void excute() {
		System.out.println("	SearchCommand 진입");
		Map<String, Object> paramMap = new HashMap<>();
		String pageNum = request.getParameter("pageNum");
		System.out.println("	SearchCommand pageNum : "+pageNum);
		PageProxy pxy = new PageProxy();
		int pn = (pageNum == null) ? 1 : Integer.parseInt(pageNum);
		System.out.println("	SearchCommand pn : "+pn);
		pxy.carryOut(pn);
		Pagination page = pxy.getPagination();
		paramMap.put("beginRow", page.getBeginRow());
		paramMap.put("endRow", page.getEndRow());
		request.setAttribute("list", MemberServiceImpl.getInstance().search(paramMap));
		request.setAttribute("page", page);
		super.excute();
		
		
		
		
		
		/*        
		// List<MemberBean> list = MemberServiceImpl.getInstance().listMember(); //list에 service에서 받은 값을 담는다
        int rowCount = MemberServiceImpl.getInstance().countMember();  //게시물수
        //int listSize=5;
        int blockSize = 5;   //1~5, 6~10
        int pageNum = (request.getParameter("pageNum") == null) ? 1 : Integer.parseInt(request.getParameter("pageNum"));
        int pageCount = (int) Math.ceil(rowCount / blockSize);  //총페이지수
        
        int beginPage= (int) (Math.floor((pageNum-1)/blockSize) * blockSize + 1);
        int endPage=(int)Math.floor(beginPage / blockSize+1) * blockSize;
        if(pageCount > endPage) {
            endPage=(int)Math.floor(beginPage / blockSize+1) * blockSize;
            System.out.println("pageCount 크다, 끝페이지 :"+endPage);
        }else {
            endPage=pageCount;
            System.out.println("--"+pageCount+"까지만, 끝페이지 :"+endPage);
        }
        
        //int prevBlock = beginPage - blockSize;
        //int nextBlock = beginPage + blockSize;
        int beginRow = (pageNum - 1) * blockSize + 1;
        int endRow = pageNum * blockSize;
        
        System.out.println(" 현재페이지 : "+pageNum+" \n 총페이지수 : "+pageCount);
        System.out.println(" 시작페이지 : "+beginPage+" \n 끝페이지 : "+endPage);
        System.out.println(" 시작로우 : "+beginRow+" \n 끝로우 : "+endRow);

        boolean existPrev=false;
        boolean existNext=false;    
        if(beginPage>1) { //시작페이지가 1이 아니면
            existPrev=true;
            System.out.println("existPrev : "+existPrev);
            if(endPage!=pageCount) {
                existNext=true;
                System.out.println("existNext : "+existNext);
            }
        }else {
            if(endPage!=pageCount) {
                existNext=true;
                System.out.println("existNext : "+existNext);
            }
        }
        
        Map<String, Object> param = new HashMap<>();
        param.put("beginRow", beginRow);
        param.put("endRow", endRow);
        List<MemberBean> mems = MemberServiceImpl.getInstance().getList(param);
        request.setAttribute("list", mems); // ★★★★ ${}안에 list를 넣어서 호출할거다
        
        request.setAttribute("count", MemberServiceImpl.getInstance().countMember());
        request.setAttribute("beginPage", beginPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("blockSize", blockSize);
        request.setAttribute("existPrev", existPrev);
        request.setAttribute("existNext", existNext);
        
        // System.out.println("endPage = "+request.getAttribute("endPage"));
        // System.out.println("----리스트커맨드 excute----");
        super.excute();
		
*/		
	}
}
