package command;

import javax.servlet.http.*;

public class Carrier { //캐리어는 명령보내는 일만 하는 클래스.
	public static void forward(HttpServletRequest request, HttpServletResponse response)  {
		try {
			System.out.println("6. carrier forward 뷰 : "+Receiver.cmd.getView());
			request.getRequestDispatcher(Receiver.cmd.getView()).forward(request, response);
		} catch (Exception e) {e.printStackTrace();}
		
		//receiver의 명령(cmd) 
		//System.out.println() 도 패턴걸린것 . Sentry.cmd.getView()유사한 모양이지 
		//view= "/WEB-INF/view/member/"+page+".jsp"
		
	}
	public static void redirect(HttpServletRequest request,HttpServletResponse response,String url) {
		try {  
			//redirect는 반환할 값이 없을때 set,update,delete 일때 써라
			response.sendRedirect(request.getContextPath()+url);
			System.out.println("6. carrier redirect :"+request.getContextPath()+url);
		} catch (Exception e) {e.printStackTrace();}
	}
}

//response는 서블릿에서 서블릿으로 

//forward 와 redirect(url로 가서 컨트롤러로 가게 됨,request의 값이 사라짐)

