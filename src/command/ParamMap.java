package command;

import javax.servlet.http.HttpServletRequest;

public class ParamMap {
	public static String getValues(HttpServletRequest request, String name) {
		String rs ="";
		String[] values = request.getParameterMap().get(name);
		StringBuffer buff = new StringBuffer();
		for(String s : values) {
			buff.append(s+",");
		}
		
		return buff.toString().substring(0,buff.toString().length()-1); //-1 :맨 마지막 쉼표 잘라냄
		
		// 체크박스 값을 가져오는 유틸이야 ★★★★
		// 완충 String 문자열을 모았다가 보내는 것.
		// 카톡보내기전에 메세지를 모아놓는 것.
		// 스트링을 차곡차곡 붙여놓는 것. 
		//수강과목을 한 문장으로 만드려고 하는 것이다 . 쉼표로 토큰을 걸어줌, 나중에 스플릿 하려고
		
	
	}
}
