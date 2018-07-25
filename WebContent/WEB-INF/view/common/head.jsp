<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>

<head>
	<meta charset="UTF-8" />
	<title>Hello</title>
	<link rel="stylesheet" type="text/css" href="${css}/style.css" />
	<script>
	
	var common = new (function (){
		this.move = function (domain, action, page) {
			console.log('클릭 테스트 성공 ${context}');
			return location.href = "${context}/" + domain + ".do?action=" + action + "&page=" + page;
			/*function의 이름을 지운 상태 = anonymous function 이다.  */
		}
	});
	/* <a onclick="common.move('member','move','user_login_form')">LOGIN </a>
	common.move 로 바꿈*/
	var member = new (function (){
		var userid, ssn, password;
		
		this.setUserid= function(x){
			this.userid=x;
		}
		this.setSsn=function(y){
			this.ssn=y;
		}
		this.setPassword =function(z){
			this.password=z;
		}
		
		this.getUserid= function(x){
			return this.userid;
		}
		this.getSsn=function(y){
			return this.ssn;
		}
		this.getPassword =function(z){
			return this.password;
		}
		//id 중복인지 미리 걸러
		//ssn 자리수, 형식 , 기존가입인지
		//password 자리수
		 this.loginvaliation = function(){
			alert('로그인 유효성 검사 시작');

			var ok=false;
			if(this.userid===""){
				alert('ID을 입력하시오');
			}else if(this.password===""){
				alert('비밀번호를 입력하시오');
			}else{
				ok=true;
			};
			return ok;
	};
});
	
	
/* 	var Member= function (){
		userid, ssn, name, age, roll, teamid, password;
		this.loginvaliation = function(){
		return 'TEST';
	};
}
	var mem = new Member();
	Member() 클래스화가 된거고
	mem 은 인스턴스
	
	
	*/
	
	
	</script>
</head>