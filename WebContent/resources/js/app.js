// router 	:단순 클릭이동
// service 	:필수항목 입력
// admin 	:관리자체크
// member 	:getter,setter/ 간단연산

"use strict";  //문법엄격히
var router = (()=> {
	return {move : x =>{
		console.log('클릭 테스트 성공 ${context}');
		
		//JSON 이용
		location.href =
			x.context +"/" 
			+  x.domain 
			+ ".do?action=" + x.action
			+ "&page=" + x.page
		
		/*//배열
		 * location.href =
			x[0] +"/" + x[1] + ".do?action=" + x[2]
				+ "&page=" + x[3]*/
	}};
})();

//5단계)JSON 사용(OOP)
var service = (()=>{
	return {
		nullChecker : x=>{
			var i = 0;					//0값으로 초기화 하는 것은 int 타입으로 정의하는 것과 같다.
			var j ={ 					//j 는 json을 의미.  json은 자바의 해시맵과 비슷
					checker : true, 	// key : value 
					text : '필수항목 입력바랍니다'
			};
			for(i in x){
				if(x[i]===""){
					j.checker = false;
				}
			}
			return j;
		}
	};
})();

var admin=(()=>{   //생성자함수처럼 쓰이는 밖의 것은, 없는 것으로 막음. 디폴트와 같은 기능
	return {
		check : x=>{
			var isAdmin = confirm('관리자입니까?');  //confirm은 window의 객체, window가 객체를 만드는 것을 bom, confirm은 bom의 메소드
			if(isAdmin){  //if 조건문 안에 연산없으면 불린타입으로 리턴하는 것
				var password = prompt('관리자비번을 입력바랍니다');
				if(password == 1){
					router.move({
						context:x,  //admin.check("${context}");에서 x값 받으니까 x로 써야해
						domain:"admin",
						action:"list",  //list를 디폴트로 둘거라서
						page:"main"
					});
				}
			}else{
				//boolean( NO인 경우)
				alert('관리자만 접근이 허용됩니다');
			}
		}
};})();




var member = (()=> {
	var _userid, _ssn, _password, _name,
	_gender, _age, _roll, _teamid, _subject; // JS에서' _값 '  <-인스턴스 변수또는 인스턴스 메소드와 비슷(보안걸때 필요)
	
	var setUserid = (userid)=>{this._userid = userid;}
	var setSsn =(ssn)=> {this._ssn = ssn;}
	var setPassword = (password)=> {this._password = password;}
	var setName = (name)=> {this._name = name;}
	var setGender = x=>{
		var gender ="";
		var gen = Number(x[2].substr(-1));
		switch(gen){
		case 1: case 3: case 5: case 7:
			gender="남";
			alert('주민번호7번째:'+gen+'\n 남/여: '+gender);
			break;
		case 2: case 4: case 6: case 8:	
			gender ="여";
			alert('주민번호7번째:'+gen+'\n 남/여: '+gender);
			break;
		}
		this._gender=gender;
		}
	var setAge = x=>{
		var date = new Date();
		var birth = x[2].substr(0,2);  
		if(birth<19){
			var res="20"+birth;
			alert('2000년대생 '+res);
		}else{
			res="19"+birth;
			alert('1900년대생 '+res);
		}
		var age = Number(date.getFullYear() - res) +1;
		alert('올해는 :'+date.getFullYear()+'\n 계산한 나이는'+age);
		this._age=age;
	}
	var setRoll = (roll)=>{this._roll=roll;}
	var setTeamid =(teamid)=>{this._teamid=teamid;}
	var setProject = (project)=>{this._project=project;}
	
	var getUserid = ()=> {return this._userid;}
	var getSsn = ()=>{return this._ssn;}
	var getPassword = ()=> {return this._password;}
	var getName = ()=> {return this._name;}
	var getGender = ()=>{return this._gender;}
	var getAge = ()=>{return this._age;}
	var getRoll = ()=>{return this._roll;}
	var getTeamid = ()=>{return this._teamid;}
	var getProject = ()=>{return this._project;}
	
	return {
		setUserid:setUserid,
		setSsn:setSsn,
		setPassword:setPassword,
		setName:setName,
		setGender:setGender,
		setAge:setAge,
		setRoll:setRoll,
		setTeamid:setTeamid,
		setProject:setProject,
			
		getUserid:getUserid,
		getSsn:getSsn,
		getPassword:getPassword,
		getName:getName,
		getGender:getGender,
		getAge:getAge,
		getRoll:getRoll,
		getTeamid:getTeamid,
		getProject:getProject,
		
		join : x=>{
			member.setAge(x);
			member.setGender(x);
		}
	};
})();
	



//return 안의 값은 public 
//생성자 내의 값은 private


//자바에서의 로직을 자바스크립트로 옮겨라
//자바스크립트는 소비자의 메모리를 쓰게 하는 연산이다.
//자바에서 보안빼고 연산을 최대한 하지 마라. 자바를 가볍게!
//노드가 빠른 이유는 DB에 바로 접근해서 (controller X)
//지금 노드의 소스다. 스크립트를 노드로 짜는중이야. 스크립트 최대약점이 보안이니까
//원래자바스크립트에는 인스턴스변수없음. _ 로 구분주는거야
//_있으면 평션사이의 공유하는 값이구나. _ 없으면 로컬변수


















//=============================================================================================================

//single thread model임 , 세미콜론으로 반드시 마무리해야함.
//var mem = new (function(){}());  //맨 뒤의 ()가 함수표시
//(()=>{})();   ()=> 는 파라미터값 없을 때 표시하고, x=> 는 파라미터값 나타냄.파라미터값은 하나만! 많아질경우 배열로 써라

//**** 기본 폼 *****
/*
var service = (()=>{
	return {validation : x=>{}};
})(); 
*/

//return {'move' : move};  //Closure  {key값(String값):value}  앞의 키값에 ''유무와 상관없이 ''있는 것으로 인식함. (빠른코딩이 목적)
//뒤의 move에 var move=function 된것을 넣어 스칼라로 완성한다.

//=============================================================================================================

//변경전 JSP
/* function Common(){
this.move = function (domain,action,page){
	alert('move:클릭 테스트 성공!!${context}'); // java의 sysout과 비슷
	alert('domain =' + domain + 'action ='+action +'page ='+page); 
	//location은 객체 href는 속
	location.href = ("common" == domain)?"${context}/"+domain+".do" : "${context}/"+domain +".do?action="+action
		+"&page="+page;
}
}
*/	

//JSP->JS) ${context} 는 JSP(서버측). js아니다. 그래서 context라는 변수로 바꿈
/*	this.move = function(context,domain, action, page) {
return location.href = context +"/" + domain + ".do?action=" + action
		+ "&page=" + page;
}*/

/*2단계) IIFE 패턴 중 배열(Array) 이용
var router = (function () {
	return {move : function(x) {
		return location.href = x[0] +"/" + x[1] + ".do?action=" + x[2]
				+ "&page=" + x[3]
	}};
}());
*/
//3단계) SINGLE THREAD MODEL 이용
/*var router = (()=> {
	return {move : x =>{
		console.log('클릭 테스트 성공 ${context}');
		location.href = x[0] +"/" + x[1] + ".do?action=" + x[2]
				+ "&page=" + x[3]
	}};
})();
*/



//=============================================================================================================
/*
var loginValidation = function loginValidation(){return ;}

var loginValidation = function (){return; }

// void도 반드시 리턴으로 처리해야함  프로그래밍쪽에서 함수는 리턴값이 있어야하고 프로시저는 리턴하면 안된다.
//즉 프로시저는 setter고 함수는 getter이다.
 */


/*1)
this.loginvaliation = function() {
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


/*3단계) SINGLE THREAD MODEL 이용
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
})();*/

/*4단계) 유효성검사 for문으로!
 * var service = (()=>{  //파라미터 봉쇄, 출입구 없음
	return {
		nullChecker : x=>{   // input값이 null인지 체크한다
			for(var i=0; i<x.length; i++){
				if(x[i]===""){
					alert('입력바랍니다.');
					return false;
				}
			}
			return true;
		}
	};
})();
*/

/* 4-2)nullChecker 이용, for문에서 in 이용하기 
var service = (()=>{  //파라미터 봉쇄, 출입구 없음
	return {
		nullChecker : x=>{   // input값이 null인지 체크한다
			for(i in x){
				if(x[i]===""){
					alert('필수항목을 입력바랍니다.');
					return false;
				}
			}
			return true;
		}
	};
})();*/


//=============================================================================================================

/*function Member() { //function이 추가 되면서 Member가 객체가 됐음
var userid, ssn, password, name;
//id 중복인지 미리 걸러
//ssn 자리수, 형식 , 기존가입인지
//password 자리수

// 게터세터 없으면 보안깨짐

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
};*/


