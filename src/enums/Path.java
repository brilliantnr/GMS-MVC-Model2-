package enums;

public enum Path {
	CONTEXT, WEBPATH, MAIN ,UPLOAD_PATH
	;
	
	@Override
	public String toString() {
		String path="";
		switch (this) {
		case CONTEXT:
			path="context";
			break;
		case WEBPATH:
			path="WEB-INF/view/";
			break;
		case MAIN:
			path="/main.jsp";
			break;
		case UPLOAD_PATH:
			path="C:\\Users\\1027\\JavaWorkSpace\\jeeworkspace\\GMS-MVC\\WebContent\\resources\\img\\upload\\";
			break;
		}
		return path;
	}
}
