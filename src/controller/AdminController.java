package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Receiver;
import enums.Action;

@WebServlet("/admin.do")  //출입구는 하나여야만 한다.
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1. AdminController ENTER !!");
		Receiver.init(request);  //step1.
		System.out.println("5. adminController 액션 : "+Receiver.cmd.getAction());
		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case MOVE:
			System.out.println("5. adminController 무브 안으로 진입");
			Carrier.forward(request, response); 
			break;
		case LIST:
			System.out.println("5. adminController 관리자 LIST ");
			Carrier.forward(request, response);
			break;
		case RETRIEVE:
			System.out.println("5. adminController 관리자  RETRIEVE ");
			Carrier.forward(request, response);
			System.out.println("-------controller 아이디찾기 END -------");
			break;
		case SEARCH:
			System.out.println("5. adminController 관리자  SEARCH ");
			Carrier.forward(request, response);
			break;
		case COUNT:
			Carrier.redirect(request, response, "/member.do?action=list&page=main&count="+request.getParameter("count")+"&listpage="+request.getParameter("listpage"));
			System.out.println("-------controller 카운트 END-------");
			break;
		}
	}

/*	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}*/

}
