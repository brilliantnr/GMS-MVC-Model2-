package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import command.*;
import domain.*;
import enums.*;
// 상수는 좋지 않음. 메모리 잡아먹기때문에 상수를 바꿔라

//이미 id,password 등의 이름은  bean에 String으로 저장 되어 있다.
//그런 상수들은 바꿀 필요가 없다.

@WebServlet({"/member.do","/admin.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1. MemberController ENTER !!");
		Receiver.init(request);  //step1.
		System.out.println("5. Controller 액션 : "+Receiver.cmd.getAction());
		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case MOVE:
			System.out.println("5. con 무브 안으로 진입");
			Carrier.forward(request, response);  //response 서블릿영역에서 활동, request 는 스크립틀릿에서 활동.
			break;
		case JOIN:
			System.out.println("5. con  JOIN--");
			Carrier.redirect(request, response,"");
			System.out.println("-------controller JOIN 결과  END-------");
			break;
		case LIST:
			System.out.println("-------controller 리스트  END-------");
			Carrier.redirect(request, response, "member.do?action=move&page=member_list");
			break;
		case SEARCH:
			//List<MemberBean> members =  ((SearchCommand) Receiver.cmd).getMembers();   //왜 getMembers는 자동완성 안뜨나?
			//Receiver.cmd 가 case SEARCH 내에 있으면 SearchCommand를 말한다.
			Carrier.redirect(request, response, "/member.do?action=move&page=search_team_result");
			System.out.println("-------controller 팀원찾기 END-------");  
			break;
		case RETRIEVE:
			Carrier.redirect(request, response,"/member.do?action=move&page=search_id_result");
			System.out.println("-------controller 아이디찾기 END -------");
			break;
		case COUNT:
			
			System.out.println("-------controller 카운트 END-------");
			break;
		case UPDATE:
			Carrier.forward(request, response);
			System.out.println("-------controller 비번변경 END-------");
			
			break;
		case DELETE:
			Carrier.redirect(request, response, "");
			System.out.println("-------controller 회원탈퇴 END------- ");
			break;
 		case LOGIN:  //★
 			System.out.println("5. con 로그인 --");
			if(request.getAttribute("match").equals("TRUE")) {
				//request.getSession().setAttribute("user", request.getAttribute("user"));  //커맨드에서 안하고 controller에서 session을 할까? 톰켓
				Carrier.forward(request, response);
				System.out.println("-------controller 로그인 END------- ");
			}else {
				Carrier.redirect(request, response, "/member.do?action=move&page=user_login_form");
			}

			break;
		default:
			Carrier.redirect(request, response, "");
			break;
		}


		}
	

/*	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	이거 지우고 doget()을 service()로 변경
	
	*/

}


























//=====================================================================================================================

/*@WebServlet({"/member/join_form.do","/member/join_result.do",
	"/member/user_login_form.do","/member/user_login_result.do",
	"/member/update_form.do","/member/update_result.do",
	"/member/delete_form.do","/member/delete_result.do",
	"/member/search_team_fo+rm.do","/member/search_team_result.do",
	"/member/search_id_form.do","/member/search_id_result.do",
	"/member/member_list.do",
	"/member/admin_login.do"}) 
	입구가 다 다른 상태
	*/

/*//입구를 통일하자
@WebServlet({"/member.do","/admin.do"})*/


//=====================================================================================================================
//case JOIN:
/*
1단계) sendRedirect 로 경로 직접 입력
response.sendRedirect(request.getContextPath()+"/member.do?action=move&page=loginFrom");

2단계) redirect
Carrier.redirect(request, response,"/member.do?action=move&page=loginFrom");
response.sendRedirect(request.getContextPath()+url);
*/

/*controller는 깨끗하게!
 * 빈에 담는건 createCommand 로 보냄
MemberBean member = new MemberBean();
member.setName(request.getParameter("new-user-name"));
member.setUserid(request.getParameter("new-user-id"));
member.setPassword(request.getParameter("new-user-password"));
member.setSsn(request.getParameter("new-user-birth"));
MemberServiceImpl.getInstance().createMember(member);
*/
/*
ContextPath는 도메인 www.naver.com : 프로젝트명
servletPath는 도메인 뒤. "/member.do?action=move&page=loginFrom"
합치면 url
 */			
//send Redirect 다시 보내준다. 서블릿이 서블릿으로 보내는 구조.
//리턴타입이 void여도 sendRedirect 안의 주소로 간다.








//=====================================================================================================================
/*노가다 체험
 * 	for (int i = 0; i < request.getServletPath().split(",").length; i++) {
	String path = request.getServletPath().split(",")[i];
	System.out.println("ServletPath :"+path);*/
	/*switch (request.getServletPath()) {
	case "/member/join_form.do":
		request.getRequestDispatcher("/member/join_form.jsp").forward(request, response);
		break;
	case "/member/join_result.do":
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		break;
	case "/member/user_login_form.do":
		request.getRequestDispatcher("/WEB-INF/view/member/user_login_form.jsp").forward(request, response);
		break;
	case "/member/user_login_result.do":
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		break;
	case "/member/admin_login.do":
		request.getRequestDispatcher("/WEB-INF/view/admin/admin_login.jsp").forward(request, response);
		break;
	case "/member/member_list.do":
		request.getRequestDispatcher("/WEB-INF/view/member/member_list.jsp").forward(request, response);
		break;
	case "/member/update_form.do":
		request.getRequestDispatcher("/WEB-INF/view/member/update_form.jsp").forward(request, response);
		break;
	case "/member/update_result.do":
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		break;
	case "/member/delete_form.do":
		request.getRequestDispatcher("/WEB-INF/view/member/delete_form.jsp").forward(request, response);
		break;
	case "/member/delete_result.do":
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		break;
	case "/member/search_team_form.do":
		request.getRequestDispatcher("/WEB-INF/view/member/search_team_form.jsp").forward(request, response);
		break;
	case "/member/search_team_result.do":
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		break;
	case "/member/search_id_form.do":
		request.getRequestDispatcher("/WEB-INF/view/member/search_id_form.jsp").forward(request, response);
		break;
	case "/member/search_id_reslut.do":
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		break;
	}*/