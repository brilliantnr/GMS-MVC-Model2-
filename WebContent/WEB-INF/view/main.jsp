<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="common/head.jsp" />
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="common/titleBox.jsp" />
			<jsp:include page="common/loginBox.jsp" />
			<jsp:include page="common/menuBox.jsp" />
		</div>
		<!-- header end -->
		<div id="content">
			<jsp:include page="common/contentBox.jsp" />
		</div>
		<!-- content end -->
		<div id="footer">
			<jsp:include page="common/footerBox.jsp" />
		</div>
	</div>
	<script>
		function move(domain, action, page) {
			console.log('클릭 테스트 성공 ${context}');
			alert('클릭 테스트 성공');
			location.href = "${context}/" + domain + ".do?action=" + action + "&page=" + page;
		}
	</script>
	<script>
		function sendForm(){
			/*form 태그에서만 
			유효성 체크하는 곳 
			
			그리고 action 하라고 함.
			*/
			alert('123');
			return true;
		}
	</script>
</body>
</html>