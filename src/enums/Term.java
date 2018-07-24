package enums;

public enum Term {
	CONTEXT, WEBPATH, MAIN 
	;
	
	@Override
	public String toString() {
		String path="";
		switch (this) {
		case CONTEXT:
			path="context";
			break;
		case WEBPATH:
			path="WEB-INF/view";
			break;
		case MAIN:
			path="/main.jsp";
			break;
		}
		return path;
	}
}
