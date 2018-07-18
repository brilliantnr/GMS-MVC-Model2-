package command;

public class MoveCommand extends Command{
	//상속받아야 한다!
	public MoveCommand(String domain,String action, String page) {
		setDomain(domain);
		setAction(action);
		setPage(page);
		excute();
	}
	
}
