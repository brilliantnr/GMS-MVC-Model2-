package command;

import javax.servlet.http.HttpServletRequest;

import domain.*;
import enums.*;
import service.*;

public class RetrieveCommand extends Command {

	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		excute();
	}
	@Override
	public void excute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			MemberBean member = new MemberBean();
			member.setName(request.getParameter("search-id-name"));
			member.setSsn(request.getParameter("search-id-birth"));
			
			String userid =((MemberBean)request.getSession().getAttribute("user")).getUserid();
			
			System.out.println("--RetrieveCommand   ID : "+userid);
			request.setAttribute("user", MemberServiceImpl.getInstance().retrieve(userid));
			
			
			ImageBean image = ImageServiceImpl.getinstance().retrieve(userid);
			
			
			String imgPath ="/upload/"+image.getImgname()+"."+image.getExtension();
			System.out.println("경로 : "+imgPath);
			request.setAttribute("imgPath", imgPath);
			
			break;
		case ADMIN:
			MemberBean mem = new MemberBean();
			mem.setUserid(request.getParameter("userid"));
			System.out.println("--ADMIN RetrieveCommand  : "+mem);
			//request.setAttribute("retrieve", MemberServiceImpl.getInstance().retrieve(mem));
			break;
		default:
			break;
		}
		super.excute();
	
	}
}
