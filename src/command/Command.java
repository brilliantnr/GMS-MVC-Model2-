package command;

public class Command implements Order{
	//2
	//인터페이스를 임플함
	
	protected String action, domain, page, view;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}
	@Override
	public void excute() {
		this.view="/WEB-INF/view/member/"+page+".jsp";   
	}
	
}
