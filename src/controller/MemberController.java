package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import command.*;
import enums.*;
// 상수는 좋지 않음. 메모리 잡아먹기때문에 상수를 바꿔라

//이미 id,password 등의 이름은  bean에 String으로 저장 되어 있다.
//그런 상수들은 바꿀 필요가 없다.

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1. MemberController ENTER !!");
		Receiver.init(request);
		System.out.println("5. Controller 액션 : "+Receiver.cmd.getAction());
		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case SEARCH:
			Carrier.forward(request, response);
			System.out.println("-------controller 팀원찾기 END-------");  
			break;
		case RETRIEVE:
			Carrier.forward(request, response);
			System.out.println("-------controller 아이디찾기 END -------");
			break;
		case MODIFY:
			Carrier.redirect(request, response,"/member.do?action=retrieve");
			System.out.println("-------controller 비번변경 END-------");
			break;
		case REMOVE:
			Carrier.redirect(request, response, "");
			System.out.println("-------controller 회원탈퇴 END------- ");
			break;
 		case MOVE:
			System.out.println("5. con 무브 안으로 진입");
			Carrier.forward(request, response);  //response 서블릿영역에서 활동, request 는 스크립틀릿에서 활동.
			break;
 		case LOGIN: 
 			System.out.println("5. con 로그인 --");
			if(request.getAttribute("match").equals("TRUE")) {
				//request.getSession().setAttribute("user", request.getAttribute("user"));  //커맨드에서 안하고 controller에서 session을 할까? 톰켓
				Carrier.forward(request, response);
				System.out.println("-------controller 로그인 END------- ");
			}else {
				System.out.println("controller 로그인 redirect ");
				Carrier.redirect(request, response, "/member.do?action=move&page=login");
			}
			break;
 		case JOIN:
			System.out.println("5. con  JOIN--");
			Carrier.redirect(request, response,"");
			System.out.println("-------controller JOIN 결과  END-------");
			break;
 		case FILEUPLOAD:
			System.out.println("5. con  FILEUPLOAD 1/ 파일업로드 진입");
			if(!ServletFileUpload.isMultipartContent(request)) {//!있으면
				System.out.println("업로드파일이 없습니다.");
				return;
			}
			System.out.println("FILEUPLOAD 2/ 업로드 파일 존재함");
			
			FileItemFactory factory = new  DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024*1024*40);//40MB
			upload.setSizeMax(1024*1024*50);//50MB
			List<FileItem> items = null;
			final String PATH = "C:\\Users\\1027\\Documents\\sample.txt";//업로드// \가 앞에 붙는 건 뒤에것을 인식해라라는 명령 ex)\n
			try {
				System.out.println("FILEUPLOAD 3/ 내부 진입");
				File file = null;
				items = upload.parseRequest(new ServletRequestContext(request));
				System.out.println("FILEUPLOAD 4/ items 생성");
				Iterator<FileItem> iter = items.iterator();
				while(iter.hasNext()) {
					System.out.println("FILEUPLOAD 5/ while 진입");
					FileItem item = iter.next();
					if(!item.isFormField()) {
						System.out.println("FILEUPLOAD 6/ if 진입");
						String fieldName = item.getFieldName();
						String fileName = item.getName();
						boolean ilInMemory = item.isInMemory();
						long sizeInBytes = item.getSize();
						file = new File(fileName);
						item.write(file);
						System.out.println("FILEUPLOAD 7/ 파일 업로드 성공");
					}else {
						System.out.println("FILEUPLOAD 8/ 파일 업로드 실패");
					}
				}
			} catch (Exception e) {e.printStackTrace();} 
			
			Carrier.redirect(request, response,"/member.do?action=retrieve");
			System.out.println("-------controller FILEUPLOAD 결과  END-------");
			break;
		default:
			Carrier.redirect(request, response, "");
			break;
		}


		}
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