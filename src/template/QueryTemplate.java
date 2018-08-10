package template;

import java.sql.PreparedStatement;
import java.util.*;
import enums.Vendor;
import factory.DatabaseFactory;
import lombok.Data;
import pool.DBConstant;

@Data   //롬복 추가해야함!!!!!!
public abstract class QueryTemplate {
	//상속하는 애니까 상속받는애들이 뭐든지 쓸 수 있게 각 변수들 만들어놓음
	int number;
	Object o;
	List<Object> list;
	Map<String, Object> map;
	PreparedStatement pstmt;
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
	
	//final 붙으면 후손들이 오버라이드 못한다
	public final void play(Map<?, ?> param) {
		this.number=0;
		this.o=null;
		this.list=new ArrayList<>();
		this.map=new HashMap<>();
		this.pstmt=null;
		
		this.map.put("vendor", Vendor.ORACLE);
		this.map.put("username", DBConstant.USERNAME);
		this.map.put("password", DBConstant.PASSWORD);
		
		//Iterator 패턴 ★★★
		Iterator<?> keys = param.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			this.map.put(key, param.get(key));
		}
		initialize();
		pstmtInit();
		startPlay();
		endPlay();
	}
	//오버로딩
	public final void play() {
		this.number=0;
		this.o=null;
		this.list=new ArrayList<>();
		this.map=new HashMap<>();
		this.pstmt=null;
		
		this.map.put("vendor", Vendor.ORACLE);
		this.map.put("username", DBConstant.USERNAME);
		this.map.put("password", DBConstant.PASSWORD);

		initialize();
		pstmtInit();
		startPlay();
		endPlay();
	}
	public void pstmtInit() {
		try {
			this.pstmt=DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));
		} catch (Exception e) {e.printStackTrace();}
	}
	
	
}

/*
abstract class
인터페이스 장점과 클래스 장점 둘다 갖는다

템플릿 메서드 왜 쓰냐면 각각 다른 직원쓰더라도 결과물 같다
안드로이드에서 필수로 쓰임

		MemberBean m = new MemberBean();  <-생성자로 
		Class<memberbean> clazz = MemberBean.class; <- 실물을 가져오는것
		
		리플렉션 
		

*/