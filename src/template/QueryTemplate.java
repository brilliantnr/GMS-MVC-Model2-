package template;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import enums.Vendor;
import lombok.Data;
import pool.DBConstant;

@Data
public abstract class QueryTemplate {
	HashMap<String, Object>map;
	List<Object> list;
	PreparedStatement pstmt;
	
	public final void play(HashMap<String, Object>map) {
		//final 붙으면 후손들이 오버라이드 못한다
		//play() 실행시키면 3개의 메소드 다 실행된다
		this.pstmt=null;
		this.list=new ArrayList<>();
		this.map=map;
		this.map.put("vendor", Vendor.ORACLE);
		this.map.put("username", DBConstant.USERNAME);
		this.map.put("password", DBConstant.PASSWORD);
		initialize();
		startPlay();
		endPlay();
	}
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
}

/*
abstract class
인터페이스 장점과 클래스 장점 둘다 갖는다

템플릿 메서드 왜 쓰냐면 각각 다른 직원쓰더라도 결과물 같다
안드로이드에서 필수로 쓰임

*/