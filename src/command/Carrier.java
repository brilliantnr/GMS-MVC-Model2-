package command;

import javax.servlet.http.*;

public class Carrier {
	public static void send(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("뷰 : "+Sentry.cmd.getView());
		request.getRequestDispatcher(Sentry.cmd.getView()).forward(request, response);
		//센트리의 명령(cmd) 
		//System.out.println() 도 패턴걸린것 . Sentry.cmd.getView()유사한 모양이지 
		//view= "/WEB-INF/view/member/"+page+".jsp"
		//캐리어는 명령보내는 일만 하는 클래스.
		
	}
}
