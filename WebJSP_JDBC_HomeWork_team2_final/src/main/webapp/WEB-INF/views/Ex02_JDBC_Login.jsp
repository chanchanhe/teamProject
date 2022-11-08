<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" />
<link href="css/loginForm.css" rel="stylesheet" />
</head>
<body>
	<div class="d-flex" id="wrapper">
		<!-- Left 수정 완료 -->
		<jsp:include page="/common/Left.jsp"></jsp:include>

		<div id="page-content-wrapper">
			<!-- Top 수정 완료 -->
			<jsp:include page="/common/Top.jsp"></jsp:include>

			<div class="login-page">

				<div class="form">
					<form action="${pageContext.request.contextPath}/loginok.member"
						method="post" name="loginForm" id="joinForm">
						<h3 style="text-align: center;">로그인</h3>
						<input type="text" name="id" id="id" placeholder="username" /> <input
							type="password" name="pwd" id="pwd" placeholder="password" />
						<button type="submit">로그인</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>