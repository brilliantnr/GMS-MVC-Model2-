//var mem = new (function(){}());

var router = (()=> {
	return {move : x =>{
		console.log('클릭 테스트 성공 ${context}');
		location.href = x[0] +"/" + x[1] + ".do?action=" + x[2]
				+ "&page=" + x[3]
	}};
})();


//파라미터값은 하나만! 많아질경우 배열로 써라


/*
var router = (function () {
	return {move : function(x) {
		console.log('클릭 테스트 성공 ${context}');
		return location.href = x[0] +"/" + x[1] + ".do?action=" + x[2]
				+ "&page=" + x[3]
	}};
}());
*/


	//return {'move' : move};  //Closure  {key값(String값):value}  키값에 ''있으나 없으나 상관없이 ''있는 것으로 인식함.
	//move에 var move=function 된것을 넣어 스칼라로 완성한다.

	/*	this.move = function(context,domain, action, page) {
		console.log('클릭 테스트 성공 ${context}');
		return location.href = context +"/" + domain + ".do?action=" + action
				+ "&page=" + page;
	}*/
   
// ()<- 이게 함수 표시.

//"${context} 는 JSP. js아니다. 그래서 변수로 바꿈

var service = (()=>{
	return {
		loginvaliation : x=>{
			alert('로그인 유효성 검사 시작');
			var ok = false;
			if (x.getUserid() === "") {
				alert('ID을 입력하시오');
			} else if (x.getPassword() === "") {
				alert('비밀번호를 입력하시오');
			} else {
				ok = true;
			}
			;
			return ok;
		},
		joinvaliation : x=>{
			var ok = false;
			if(x.getUserid()===""){
				alert('ID을 입력하시오');
			}else if(x.getName()===""){
				alert('이름을 입력하시오');
			}else if(x.getSsn()===""){
				alert('주민번호를 입력하시오');
			}else if(x.getPassword()===""){
				alert('비밀번호를 입력하시오');
			}else {
				ok=true;
			}
			return ok;
		}
	};
})();

function Member() {
	var userid, ssn, password, name;
	
//function이 추가 되면서 Member가 객체가 됐음
	this.setUserid = function(x) {
		this.userid = x;
	}
	this.setSsn = function(y) {
		this.ssn = y;
	}
	this.setPassword = function(z) {
		this.password = z;
	}
	this.setName = function(z) {
		this.name = z;
	}

	this.getUserid = function(x) {
		return this.userid;
	}
	this.getSsn = function(y) {
		return this.ssn;
	}
	this.getPassword = function(z) {
		return this.password;
	}
	this.getName = function(z) {
		return this.name;
	}
};


	//id 중복인지 미리 걸러
	//ssn 자리수, 형식 , 기존가입인지
	//password 자리수
	/*this.loginvaliation = function() {
		alert('로그인 유효성 검사 시작');

		var ok = false;
		if (this.userid === "") {
			alert('ID을 입력하시오');
		} else if (this.password === "") {
			alert('비밀번호를 입력하시오');
		} else {
			ok = true;
		}
		;
		return ok;
	};*/

/*
x=y   처럼 세미콜론 안찍었을 경우??
function (){}(); //에러
(function (){})();  //goofy 멍청
(function (){}());  //Groovy!  멋짐
*/