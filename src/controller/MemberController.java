package controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import command.Carrier;
import command.Sentry;
import domain.*;
import enums.Action;
import service.*;
// 상수는 좋지 않음. 메모리 잡아먹기때문에
// 상수를 바꿔라

//이미 id,password 등의 이름은  bean에 String으로 저장 되어 있다.
//그런 상수들은 바꿀 필요가 없다.


/*@WebServlet({"/member/join_form.do","/member/join_result.do",
	"/member/user_login_form.do","/member/user_login_result.do",
	"/member/update_form.do","/member/update_result.do",
	"/member/delete_form.do","/member/delete_result.do",
	"/member/search_team_form.do","/member/search_team_result.do",
	"/member/search_id_form.do","/member/search_id_result.do",
	"/member/member_list.do",
	"/member/admin_login.do"}) 
	입구가 다 다른 상태
	*/

//입구를 통일하자
@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController ENTER !!");
		Sentry.init(request);  //step1.센트리가 command 생성하고 대장한테 보고. 대장한테 moveCommand받아옴.
		System.out.println("액션 : "+Sentry.cmd.getAction());
		MemberBean member = null;
		switch (Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		// 스위치 내에 명령 값이 숨겨져있다.
		//Action.valueOf() 에 Sentry.cmd.getAction().toUpperCase() 넣음
		
		case MOVE:
			try {
			System.out.println("--controller 무브 안으로 진입");
			Carrier.send(request, response);
			//switch 통과후 step2. 캐리어가 view 나타냄
			}catch (Exception e) {e.printStackTrace();}
			
			break;
		case JOIN:
			member = new  MemberBean();
			member.setName(request.getParameter("new-user-name"));
			member.setUserid(request.getParameter("new-user-id"));
			member.setSsn(request.getParameter("new-user-birth"));
			member.setPassword(request.getParameter("new-user-password"));
			//MemberServiceImpl.getInstance().createMember(member);
			response.sendRedirect(request.getContextPath()+"/member.do?action=move&page=loginFrom");
			//ContextPath는 도메인 www.naver.com : 프로젝트명
			//servletPath는 도메인 뒤. "/member.do?action=move&page=loginFrom"
			//합치면 url
			
			//send Re-direct 다시 보내준다. 서블릿이 서블릿으로 보내는 구조.
			//리턴타입이 void여도 sendRedirect 안의 주소로 간다.
			//
			
			System.out.println("**controller JOIN 결과 : "+member);
			break;
		case LIST:
			//MemberServiceImpl.getInstance().listMember();
			System.out.println("**controller 리스트  ");
			break;
		case SEARCH:
			String team = request.getParameter("search-team");
			//MemberServiceImpl.getInstance().searchTeamByName(team);
			System.out.println("**controller 팀원찾기 : "+team);
			break;
		case RETRIEVE:
			member = new MemberBean();
			member.setName(request.getParameter("search-id-name"));
			member.setSsn(request.getParameter("search-id-birth"));
			//MemberServiceImpl.getInstance().findMemberId(member);
			System.out.println("**controller 아이디찾기 : "+member);
			break;
		case COUNT:
			//MemberServiceImpl.getInstance().countMember();
			System.out.println("**controller 카운트");
			break;
		case UPDATE:
			member =new MemberBean();
			member.setUserid(request.getParameter("update-check-id"));
			member.setPassword(request.getParameter("update-old-password")+"/"+request.getParameter("update-new-password"));
			//MemberServiceImpl.getInstance().updateMember(member);
			System.out.println("**controller 비번변경 : "+member);
			break;
		case DELETE:
			member=new MemberBean();
			member.setUserid(request.getParameter("delete-id"));
			member.setPassword(request.getParameter("delete-pw"));
			//MemberServiceImpl.getInstance().deleteMember(member);
			response.sendRedirect(request.getContextPath()+"/member.do?action=move&page=loginFrom");
			System.out.println("**controller 회원탈퇴 : "+member);
			break;
		case LOGIN:
			member=new MemberBean();
			member.setUserid(request.getParameter("user-id"));
			member.setPassword(request.getParameter("user-password"));
			//MemberServiceImpl.getInstance().login(member);
			System.out.println("**controller 로그인 : "+member);
			break;
		default:
			break;
		}
		
/*		for (int i = 0; i < request.getServletPath().split(",").length; i++) {
			String path = request.getServletPath().split(",")[i];
			System.out.println("ServletPath :"+path);*/
			/*switch (request.getServletPatㄴ()) {
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

		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
