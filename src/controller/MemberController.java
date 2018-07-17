package controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

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
		
		switch (action) {
		case "move":
			System.out.println("이동할 페이지 : "+page);
			request.getRequestDispatcher("/WEB-INF/view/member/"+page+".jsp").forward(request, response);
			break;
		default:
			break;
		}
		
		
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
