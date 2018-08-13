package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import enums.Term;

@WebServlet("/common.do")
public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	enum Resources{CONTEXT, CSS, JS, IMG}//커먼컨트롤러 움직일때 한번만 쓰는 거라 이너클래스 형태로 만든 것.  

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i = 0;
		for (Resources r : Resources.values()) {
			request.getSession()
				.setAttribute(r.toString().toLowerCase(),
					(i == 0) ? 
							request.getContextPath() : 
								request.getContextPath() + "/resources/" + r.toString().toLowerCase());
			i++;
		}
		request.getRequestDispatcher(
				Term.WEBPATH.toString() 
				+ request.getServletPath()
					.substring(1, request.getServletPath().indexOf("."))
				+ Term.MAIN.toString())
				.forward(request, response);

	}
}

/* request.getServletPath().substring(1, request.getServletPath().indexOf("."))
 * request.getServletPath().split("/")[1].split("\\.")[0] 는 아래와 같다
	split(".") <-- 점만 넣으면 안먹어서 "\\." 으로 넣었다
 * 
*/


