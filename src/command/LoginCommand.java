package command;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import domain.*;
import service.MemberServiceImpl;


public class LoginCommand extends Command {
	public LoginCommand(HttpServletRequest request) {  //커맨드 리퀘스트
		//command가 뷰 주소값 나타낸다. R,D,A,P 
		setRequest(request);  //커맨드리퀘스트가 담김
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));  //memberController를 먼저 통과해야하니까 request.로 받아야함
		excute();
	}
	@Override
	public void excute() {
		System.out.println("LoginCommand  excute ");
		request.setAttribute("pagename", request.getParameter("page"));
		MemberBean member = new MemberBean();
		member.setUserid(request.getParameter("user-id"));
		member.setPassword(request.getParameter("user-password"));
		if(MemberServiceImpl.getInstance().login(member)) {
			request.setAttribute("match", "TRUE");
			System.out.println("LoginCommand 로그인 성공");
			request.getSession().setAttribute(
					"user"
					, MemberServiceImpl.getInstance().retrieve(member.getUserid()));
		}else {
				request.setAttribute("match", "FALSE");
				System.out.println("LoginCommand 로그인 실패");
			}
		super.excute();
	}
}










/*
6단계) 정적 코딩제거하기 (★메소드나 function 내에서 해야함)
(before - 정적코딩)
<input type="hidden" name="action" value="delete" /> 
<input type="hidden" name="page" value="delete_result" />

방법1) JSP의 <script>에서 function()내에서 작업
//1.createElement 2.innerHTML 3.appendChild
var node = document.createElement('input');  //기존에 존재하는 input 생성 (create) //없는 존재를 태그로 만드는 것을 node라고 함.
node.innerHTML = '<input type="hidden" name="action" value="delete" />'  //hidden 숨길 의도니까 html상에서 없애자
form.appendChild(node); 		
form.submit();

방법2)Java의 메소드() 내에서 작업
//setPage(request.getParameter("page")가 아닌
setPage("mypage");	//<-도착지 servlet이 결정하게하고 input삭제

*/

//setPage("mypage");  //도착지 servlet이 결정하게하자. input에 hidden하지 않기 위해 <input type="hidden" name="page" value="mypage"/>


//request는 page단위로 살아있음. getSession은 브라우저 단위니까 붙여서 살아있기