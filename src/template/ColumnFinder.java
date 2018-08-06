package template;

import java.lang.reflect.Field;

import domain.MemberBean;
import enums.Domain;

public class ColumnFinder {
	public static String find(Domain dom) {
		String s = "";
		Class<MemberBean> clazz = null;  
		switch (dom) {
		case MEMBER:
			clazz=MemberBean.class; // class를 이름만 알면 가져와서.
			break;
		default:
			break;
		}
		Field[] f = clazz.getDeclaredFields();   //import java.lang.reflect.Field; 리플렉션
		//Field[] : 필드 리스트 확인
		for(int i =0;i<f.length;i++) {
			s+=(i!=(f.length-1))?
					f[i].getName()+",":
						f[i].getName();
		}
		return s;
	}
}
