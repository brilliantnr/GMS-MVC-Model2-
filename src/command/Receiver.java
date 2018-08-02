package command;

import javax.servlet.http.HttpServletRequest;

public class Receiver {  
	//센트리는 명령 수행한다 
	// 왜 static 으로 줬을까? 단 하나의 커맨드만 처리하는 것.
	//subString  1번부터 가는 이유 : 0번째에 /가 있음
	//도메인 위주로 돌아간다
	
	public static Command cmd=new Command();
	public static void init(HttpServletRequest request) {
		String servletPath = request.getServletPath();   // servletPath ="/member.do"
		System.out.println("2. Reciver request.getServletPath() : "+servletPath.substring(1, servletPath.indexOf(".")));
		cmd=Commander.order(request);  //commander에서 cmd가 죽으면서 남긴 주소값이 receiver의 static cmd 에게 넘어간다.
		
		//주소값을 받지 않은 상태가 되면 null pointer Exception 오류가 뜰 수 있다.
		//null은 주소가 있지만 할당받지 않은 상태
		
		/*cmd=Commander.order(servletPath.substring(1,servletPath.indexOf(".")),  //member 만 호출
				request.getParameter("action"),
				request.getParameter("page"));*/
	}
}
