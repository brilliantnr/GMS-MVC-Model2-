<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="../common/titleBox.jsp" />
			<jsp:include page="../common/menuBox.jsp" />
		</div>
		<!-- header end -->
		<div id="content">
			<jsp:include page="../member/search.jsp" />
		</div>
		<!-- content end -->
		<div id="footer">
			<jsp:include page="../common/footerBox.jsp" />
		</div>
	</div>
	<script>
		admin.main('${context}');
	</script>
</body>
</html>