<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" />
<link href="css/loginForm.css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
 //jquery 로 간단하게 유효성 check 하기
 $(function() {
  	$('#joinForm').submit(function() {
	   //alert("가입");
	if ($('#id').val() == "") { // 아이디 검사
    	alert('ID를 입력해 주세요.');
    	$('#id').focus();
    return false;
   } else if ($('#pwd').val() == "") { // 비밀번호 검사
    alert('PWD를 입력해 주세요.');
    $('#pwd').focus();
    return false;
   }else if ($('#mname').val() == "") { // 이름 검사
    alert('mname를 입력해 주세요.');
    $('#mname').focus();
    return false;
   }else if ($('#age').val() == "") { // 나이 검사
    alert('age를 입력해 주세요.');
    $('#age').focus();
    return false;
   }else if ($('#email').val() == "") { // 우편번호
    alert('email를 입력해 주세요.');
    $('#email').focus();
    return false;
   }
   
  });
 });
</script>
<!--  
CREATE TABLE koreaMember
(
    id VARCHAR2(50) PRIMARY KEY ,
    pwd VARCHAR2(50) NOT NULL,
    NAME VARCHAR2(50) NOT NULL,
    age NUMBER ,
    gender CHAR(4),
    email VARCHAR2(50),
    ip   VARCHAR2(50)
)
-->

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
					    <form class="register-form" action="${ pageContext.request.contextPath }/joinok.member" method="post" name="joinForm" id="joinForm">
					      <h3>회원가입</h3>
					      <input type="text" name="id" id="id" placeholder="id"/>
					      <input type="password" name="pwd" id="pwd" placeholder="password" />				     
					      <input type="text" name="mname" id="mname" placeholder="name" />
					      <input type="text" name="age" id="age" maxlength="3" placeholder="age" />
				          <select name="gender">
				            <option value="여">여자</option>
   							<option value="남">남자</option>
				          </select>
						  <input type="text" name="email" id="email" placeholder="email">  
						  <div class = "flex-direction-row">
							  <button type="submit">회원가입</button>
							  <button type="reset">취소</button>
						  </div>	
					    </form>
					  </div>
			    </div>
								 
			 
	     </div>	        
     </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script src="js/scripts.js"></script>  	
</body>
</html>