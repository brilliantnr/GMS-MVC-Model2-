package command;

import javax.servlet.http.HttpServletRequest;

import enums.Action;

public class Commander{
	public static Command order(HttpServletRequest request) {
		Command cmd = null;
		switch (Action.valueOf(request.getParameter("action").toUpperCase())) {
		case MOVE:
			System.out.println("--Commander MOVE 진입--");
			cmd = new MoveCommand(request);
			break;
		case JOIN:
			System.out.println("--Commander JOIN 진입--");
			cmd = new CreateCommand(request);
			break;
		case LIST:
			System.out.println("-- Commander LIST 진입--");
			cmd =new ListCommand(request);
			break;
		case SEARCH:	
			System.out.println("-- Commander SEARCH 진입--");
			cmd =new SearchCommand(request);
			break;
		case RETRIEVE:
			System.out.println("-- Commander RETRIEVE 진입--");
			cmd =new RetrieveCommand(request);
			break;
		case COUNT:
			System.out.println("-- Commander COUNT 진입--");
			break;
		case UPDATE:
			System.out.println("-- Commander UPDATE 진입--");
			cmd =new UpdateCommand(request);
			break;
		case DELETE:
			System.out.println("-- Commander DELETE 진입--");
			cmd =new DeleteCommand(request);
			break;
		case LOGIN:
			System.out.println("-- Commander LOGIN 진입--");
			cmd =new LoginCommand(request);
			break;
		}
		return cmd;
	}

	
}
