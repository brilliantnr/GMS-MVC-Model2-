package command;

import javax.servlet.http.HttpServletRequest;

import enums.Action;

public class Commander{
	public static Command order(HttpServletRequest request) {
		Command cmd = null;   //cmd는 레퍼런스
		switch (Action.valueOf(request.getParameter("action").toUpperCase())) {
		case SEARCH:
			System.out.println("3. Commander SEARCH 진입--");
			cmd =new SearchCommand(request);
			break;
		case RETRIEVE:
			System.out.println("3. Commander RETRIEVE 진입--");
			cmd =new RetrieveCommand(request);
			break;
		case COUNT:
			System.out.println("3. Commander COUNT 진입--");
			cmd=new CountCommand(request);
			break;
		case MODIFY:
			System.out.println("3. Commander UPDATE 진입--");
			cmd =new ModifyCommand(request);
			break;
		case REMOVE:
			System.out.println("3. Commander DELETE 진입--");
			cmd =new RemoveCommand(request);
			break;
		case LOGIN:
			System.out.println("3. Commander LOGIN 진입--");
			cmd =new LoginCommand(request);
			break;
		case MOVE:
			System.out.println("3. Commander MOVE 진입--");
			cmd = new MoveCommand(request);  //cmd는 레퍼런스
			break;
		case JOIN:
			System.out.println("3. Commander JOIN 진입--");
			cmd = new AddCommand(request);
			break;
		case FILEUPLOAD:
			System.out.println("3. Commander FILEUPLOAD 진입--");
			cmd = new FileCommand(request);
			break;
		
		}
		return cmd;  //cmd 죽음, 주소값은 남김
	}

	
}
