package command;

import javax.servlet.http.HttpServletRequest;

public class Sentry {  
	//센트리는 명령 수행한다 
	// 왜 static 으로 줬을까? 단 하나의 커맨드만 처리하는 것.
	// servletPath ="/member.do"
	//패턴은 규격화
	//subString  1번부터 가는 이유 : 0번째에 /가 있음
	//도메인 위주로 돌아간다
	
	public static Command cmd=new Command();
	public static void init(HttpServletRequest request) {
		String servletPath = request.getServletPath();   
		System.out.println("센트리 : "+servletPath.substring(1, servletPath.indexOf(".")));
		cmd=Commander.order(servletPath.substring(1,servletPath.indexOf(".")),  //member 만 호출
				request.getParameter("action"),
				request.getParameter("page"));
	}
}
