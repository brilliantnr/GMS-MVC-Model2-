package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import enums.Term;

@WebServlet("/common.do")
public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	enum Resources{  //★★★★
		CONTEXT, CSS, JS, IMG
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i = 0;
		for (Resources r : Resources.values()) {
			request.getSession().setAttribute(
					r.toString().toLowerCase(), 
					(i == 0) ? 
					request.getContextPath() :
					request.getContextPath() + "/resources/" + r.toString().toLowerCase());
			i++;
		}
		request.getRequestDispatcher(Term.WEBPATH.toString()+Term.MAIN.toString()).forward(request,response);
		
		
		
		
		
		
		
		/*3차
		int i =0;
		
		for(Resources r: Resources.values()) {
			if(i==0) {
				request.getSession().setAttribute(r.toString().toLowerCase(), request.getContextPath());
			}else {
				System.out.println(request.getContextPath()+"/resources/"+r.toString().toLowerCase());
				request.getSession().setAttribute(r.toString().toLowerCase(), request.getContextPath()+"/resources/"+r.toString().toLowerCase());
			}  //삼항연산자로 고치기 전
			i++;
		}
		request.getRequestDispatcher(Domain.WEBPATH.toString()+Domain.MAIN.toString()).forward(request,response);
		*/
		
		
		/*2차
		 * request.getSession().setAttribute(Domain.CONTEXT.toString(), request.getContextPath());
		request.getRequestDispatcher(Domain.WEBPATH.toString()+Domain.MAIN.toString()).forward(request,response);*/
		
		
		/*1차
		 * HttpSession  session = request.getSession();
		session.setAttribute(Domain.CONTEXT.toString(), request.getContextPath());   
		//★★★★ contextPath도 request가 갖고 있다. 연관관계로
		request.getRequestDispatcher("WEB-INF/view/main.jsp").forward(request, response);*/
	}
}
