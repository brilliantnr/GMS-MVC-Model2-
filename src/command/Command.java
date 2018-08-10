package command;

import javax.servlet.http.*;
import lombok.Data;

@Data
public class Command implements Order{
	protected HttpServletRequest request;
	protected String action, domain, view;

	@Override
	public void excute() {
		this.view="/WEB-INF/view/"+domain+"/main.jsp";   
	}
	//무조건 main으로 간다
	
}
