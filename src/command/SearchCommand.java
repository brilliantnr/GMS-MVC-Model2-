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
		default:
			break;
		}
		super.excute();
	}
}
