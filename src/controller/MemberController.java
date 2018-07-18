package controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import domain.*;
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
		String action = request.getParameter("action");
		String page = request.getParameter("page");
		MemberBean member = null;
		switch (action) {
		case "move":
			System.out.println("--controller 이동할 페이지 : "+page);
			request.getRequestDispatcher("/WEB-INF/view/member/"+page+".jsp").forward(request, response);
			break;
		case "join":
			member = new  MemberBean();
			member.setName(request.getParameter("new-user-name"));
			member.setUserid(request.getParameter("new-user-id"));
			member.setSsn(request.getParameter("new-user-birth"));
			member.setPassword(request.getParameter("new-user-password"));
			MemberServiceImpl.getInstance().createMember(member);
			System.out.println("**controller JOIN 결과 : "+member);
			break;
		case "memberlist":
			MemberServiceImpl.getInstance().listMember();
			System.out.println("**controller 리스트  ");
			break;
		case "searchMemberByTeam":
			String team = request.getParameter("search-team");
			MemberServiceImpl.getInstance().searchTeamByName(team);
			System.out.println("**controller 팀원찾기 : "+team);
			break;
		case "searchMemberId":
			member = new MemberBean();
			member.setName(request.getParameter("search-id-name"));
			member.setSsn(request.getParameter("search-id-birth"));
			MemberServiceImpl.getInstance().findMemberId(member);
			System.out.println("**controller 아이디찾기 : "+member);
			break;
		case "memberCount":
			MemberServiceImpl.getInstance().countMember();
			System.out.println("**controller 카운트");
			break;
		case "memberUpdate":
			member =new MemberBean();
			member.setUserid(request.getParameter("update-check-id"));
			member.setPassword(request.getParameter("update-old-password")+"/"+request.getParameter("update-new-password"));
			MemberServiceImpl.getInstance().updateMember(member);
			System.out.println("**controller 비번변경 : "+member);
			break;
		case "memberDelete":
			member=new MemberBean();
			member.setUserid(request.getParameter("delete-id"));
			member.setPassword(request.getParameter("delete-pw"));
			MemberServiceImpl.getInstance().deleteMember(member);
			System.out.println("**controller 회원탈퇴 : "+member);
			break;
		case "login":
			member=new MemberBean();
			member.setUserid(request.getParameter("user-id"));
			member.setPassword(request.getParameter("user-password"));
			MemberServiceImpl.getInstance().login(member);
			System.out.println("**controller 로그인 : "+member);
// 성공인지 실패인지
			break;
		default:
			break;
		}
		request.getRequestDispatcher("/WEB-INF/view/member/"+page+".jsp").forward(request, response);
		
/*		for (int i = 0; i < request.getServletPath().split(",").length; i++) {
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

		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
