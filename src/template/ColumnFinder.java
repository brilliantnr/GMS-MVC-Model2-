package template;

import java.lang.reflect.Field;

import domain.ImageBean;
import domain.MemberBean;
import enums.Domain;

public class ColumnFinder {
	public static String find(Domain dom) {
		String s = "";
		Class<MemberBean> classMem = null;
		Class<ImageBean> classImg = null;
		switch (dom) {
		case MEMBER:
			classMem = MemberBean.class; // class를 이름만 알면 가져와서.
			Field[] f = classMem.getDeclaredFields();   //import java.lang.reflect.Field; 리플렉션
			//Field[] : 필드 리스트 확인
			for(int i =0;i<f.length;i++) {
				s+=(i!=(f.length-1))?
						f[i].getName()+",":
							f[i].getName();
			}
			break;
		case IMAGE:
			classImg = ImageBean.class;
			Field[] f1 = classImg.getDeclaredFields();
			//Field[] : 필드 리스트 확인
			for(int i =0;i<f1.length;i++) {
				s+=(i!=(f1.length-1))?
						f1[i].getName()+",":
							f1[i].getName();
			}
			break;
		}
		
/*		Field[] f = classMem.getDeclaredFields();   //import java.lang.reflect.Field; 리플렉션
		//Field[] : 필드 리스트 확인
		for(int i =0;i<f.length;i++) {
			s+=(i!=(f.length-1))?
					f[i].getName()+",":
						f[i].getName();
		}*/
		return s;
	}
}
