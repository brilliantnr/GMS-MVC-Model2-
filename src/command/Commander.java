package command;

import javax.servlet.http.HttpServletRequest;

import enums.Action;

public class Commander{
	public static Command order(HttpServletRequest request) {
		Command cmd = null;   //cmd는 레퍼런스
		switch (Action.valueOf(request.getParameter("action").toUpperCase())) {
		case MOVE:
			System.out.println("3. Commander MOVE 진입--");
			cmd = new MoveCommand(request);  //cmd는 레퍼런스
			break;
		case JOIN:
			System.out.println("3. Commander JOIN 진입--");
			cmd = new CreateCommand(request);
			break;
		case LIST:
			System.out.println("3. Commander LIST 진입--");
			cmd =new ListCommand(request);
			break;
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
			break;
		case UPDATE:
			System.out.println("3. Commander UPDATE 진입--");
			cmd =new UpdateCommand(request);
			break;
		case DELETE:
			System.out.println("3. Commander DELETE 진입--");
			cmd =new DeleteCommand(request);
			break;
		case LOGIN:
			System.out.println("3. Commander LOGIN 진입--");
			cmd =new LoginCommand(request);
			break;
		}
		return cmd;  //cmd 죽음, 주소값은 남김
	}

	
}
