package command;

import javax.servlet.http.HttpServletRequest;

import domain.*;
import enums.*;
import service.MemberServiceImpl;

public class CreateCommand extends Command{
	public CreateCommand(HttpServletRequest request) {  
		setRequest(request); 
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		this.excute();
	}
	
	@Override
	public void excute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		//Receiver.cmd.domain.toUpperCase())
		//Receiver.cmd가 cmd 리턴되지 않은 상태기때문에 현재 null상태
		//Commander에서 리턴한다음에 할당해줘야 Receiver.cmd가 되는 것.
		//상속관계니까 (Command에 있는) domain이라고 쓰면 됨
		//만약 상속관계쓰면 안되는 상황이면 getDomain() 쓰면 된다.
		
		case MEMBER:
			System.out.println("회원가입에 들어옴");
			MemberBean member = new MemberBean();
			member.setName(request.getParameter("name"));
			member.setUserid(request.getParameter("userid"));
			member.setPassword(request.getParameter("password"));
			member.setSsn(request.getParameter("ssn"));
			member.setGender(request.getParameter("gender"));
			member.setAge(request.getParameter("age"));
			member.setRoll(request.getParameter("roll"));
			member.setTeamId(request.getParameter("teamid"));
			member.setSubject(request.getParameter("subject"));
			MemberServiceImpl.getInstance().createMember(member);
			System.out.println("---회원가입 성공 --");
			break;
		default:
			break;
		}
		super.excute();
	}
}
