package command;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import domain.*;
import enums.*;
import service.*;

public class SearchCommand extends Command {
	List<MemberBean> members;
	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		excute();
	}

	@Override
	public void excute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			String teamName = request.getParameter("search-team");
			MemberServiceImpl.getInstance().searchTeamByName(teamName);
			break;
		case ADMIN:
			String word = request.getParameter("word");
			//request.getParameter(주소값의 key값);
			String option = request.getParameter("option");
			System.out.println("request.getParameter(option) : "+option);
			System.out.println("request.getParameter(\"word\") : "+word);
			request.setAttribute("list", MemberServiceImpl.getInstance().searchMemberByWord(option+"/"+word));
			System.out.println("----Search커맨드 excute----");
			break;
		default:
			break;
		}
		super.excute();
	}
}
